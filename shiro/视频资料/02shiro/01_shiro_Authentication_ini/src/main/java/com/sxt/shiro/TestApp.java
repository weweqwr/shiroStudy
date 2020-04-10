package com.sxt.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * 用户认证
 * @author LJH
 *
 */
public class TestApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String username="zhangsan1";
		String password="123456";
		//1,创建securityManager工厂 SecurityManager JDK也有这个类,在java.lang包 注意不要使用jdk里面那个类
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//2,从工厂里面得到SecurityManager
		SecurityManager securityManager = factory.getInstance();
		//3,把当前的SecurityManager绑定到当前线程
		SecurityUtils.setSecurityManager(securityManager);
		//4,取出当前的Subject
		Subject subject = SecurityUtils.getSubject();
//		System.out.println(subject);
		//5,封装用户名和密码
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		try {
			//6,进行登陆认证
			subject.login(token);
			System.out.println("是否认证成功:"+subject.isAuthenticated());
		} catch (AuthenticationException e) {
			System.out.println("用户名或密码不正确");
		}
		/*try {
			//6,进行登陆认证
			subject.login(token);
			System.out.println("是否认证成功:"+subject.isAuthenticated());
		} catch (IncorrectCredentialsException e) {
			System.out.println("密码不正确");
		} catch (UnknownAccountException e) {
			System.out.println("用户名不存在");
		}
//		
*///		a();
//		
//		b();
//		
//		
////		ThreadLocal<Subject> xxx=new ThreadLocal<>();
////		xxx.get();
////		xxx.set(value);
	}
	
	static void a() {
		Subject subject = SecurityUtils.getSubject();
		System.out.println(subject);
	}
	
	static void b() {
		Subject subject = SecurityUtils.getSubject();
		System.out.println(subject);
	}

}
