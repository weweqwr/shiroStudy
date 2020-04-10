package com.longer.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.longer.utils.ActiveUser;

@Controller
@RequestMapping("login")
public class LoginController {
	//跳转到登录页面
	@RequestMapping("toLogin")
	public String login(){
		return "login";
	}
	//完成登录的方法
	@RequestMapping("login")
	public String login(String username, String password, HttpSession session){
		//得到主体
		Subject subject=SecurityUtils.getSubject();
		//封装用户名和密码
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
			ActiveUser activeUser=(ActiveUser) subject.getPrincipal();
			session.setAttribute("user", activeUser.getUser());
			return "redirect:/user/loadAllUser.action";
		} catch (Exception e) {
			System.out.println("用户名或密码不正确");
		}
		
		return "redirect:/index.jsp";
	}

}
