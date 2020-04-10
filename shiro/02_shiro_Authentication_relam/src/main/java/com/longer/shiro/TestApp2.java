package com.longer.shiro;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
/**
 * 
 * 自定义relam实现认证
 * 1、创建user
 * 2、创建UserService
 * 3、创建UserServiceImpl
 * 4、创建UserReaml
 * 5、创建测试类
 * **/
public class TestApp2 {
	public static void main(String[] args) {
		String username="zhansan";
		String password="123456";
		//1、创建一个安全管理器的工厂
		//SecurityManager jdk也有这个类，在java.lang包注意不要使用jdk里面那个类
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//2、从工厂里面得到SecurityMnager
		DefaultSecurityManager securityManager=(DefaultSecurityManager) factory.getInstance();
		
		Realm realm=new UserRealm();
		securityManager.setRealm(realm);
		
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
			Object object=subject.getPrincipal();//得到doGetAuthenticationInfo的放回值SimpleAuthenticateionInfo里面的第一个参数
			System.out.println(object);
		}catch(AuthenticationException e){
			//ctrl+t看类得继承关系
			System.out.println("用户名或密码不正确");
		}
		//1、判断用户是否有某一个角色
		boolean hasRole1=subject.hasRole("role1");
		System.out.println(username+"是否有role1得角色"+hasRole1);
			
	}
}
