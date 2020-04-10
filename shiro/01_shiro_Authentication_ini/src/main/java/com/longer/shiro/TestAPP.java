package com.longer.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
/**
 * 用户认证
 * **/
public class TestAPP {
	public static void main(String[] args) {
		String username="zhansan";
		String password="1234563";
		//1、创建一个安全管理器的工厂
		//SecurityManager jdk也有这个类，在java.lang包注意不要使用jdk里面那个类
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//2、从工厂里面得到SecurityMnager
		SecurityManager securityManager=factory.getInstance();
		//3、把当前得SecurityManager绑定到当前得线程
		SecurityUtils.setSecurityManager(securityManager);
		//4,取出当前得Subject
		Subject subject=SecurityUtils.getSubject();
		System.out.println(subject);
		//5、封装用户名和密码
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		try {
			//6、进行登录认证
			subject.login(token);
			System.out.println("是否认证成功"+subject.isAuthenticated());//subject.isAuthenticated判断是否验证成
//		} catch (IncorrectCredentialsException e) {
//			// TODO Auto-generated catch block
//			System.out.println("密码不正确");
//		}catch (UnknownAccountException e) {
//			// TODO Auto-generated catch block
//			System.out.println("用户名不正确");
//		}
		}catch(AuthenticationException e){
			//ctrl+t看类得继承关系
			System.out.println("用户名或密码不正确");
		}
		
//		a();
//		b();
//		ThreadLocal<Subject> xxx=new ThreadLocal<>();
//		xxx.get();
//		xx.set();
	}
	static void a(){
		Subject subject=SecurityUtils.getSubject();
		System.out.println(subject);
	}
	static void b(){
		Subject subject=SecurityUtils.getSubject();
		System.out.println(subject);
	}

}
