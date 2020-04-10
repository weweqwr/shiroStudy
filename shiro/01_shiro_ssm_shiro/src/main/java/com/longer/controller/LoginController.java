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
	//��ת����¼ҳ��
	@RequestMapping("toLogin")
	public String login(){
		return "login";
	}
	//��ɵ�¼�ķ���
	@RequestMapping("login")
	public String login(String username, String password, HttpSession session){
		//�õ�����
		Subject subject=SecurityUtils.getSubject();
		//��װ�û���������
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
			ActiveUser activeUser=(ActiveUser) subject.getPrincipal();
			session.setAttribute("user", activeUser.getUser());
			return "redirect:/user/loadAllUser.action";
		} catch (Exception e) {
			System.out.println("�û��������벻��ȷ");
		}
		
		return "redirect:/index.jsp";
	}

}
