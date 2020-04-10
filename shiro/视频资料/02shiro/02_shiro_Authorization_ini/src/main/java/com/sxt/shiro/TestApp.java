package com.sxt.shiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * 用户认证授权
 * @author LJH
 *
 */
public class TestApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String username="zhangsan";
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
		
		//1,判断用户是否有某一个角色
		boolean hasRole1 = subject.hasRole("role1");
		System.out.println(username+"是否有role1的角色:"+hasRole1);
		//2,判断用户是否同时拥有集合里面的所有角色
		List<String> roleIdentifiers=new ArrayList<>();
		roleIdentifiers.add("role1");
		roleIdentifiers.add("role2");
		roleIdentifiers.add("role3");
		boolean allRoles = subject.hasAllRoles(roleIdentifiers);
		System.out.println(username+"是否同时拥有roleIdentifiers集合里面的所有角色:"+allRoles);
		//3,分别判断用户是否有集合里面的角色
		boolean[] hasRoles = subject.hasRoles(roleIdentifiers);
		System.out.println("分别判断用户是否有集合里面的角色:"+Arrays.toString(hasRoles));
		
		
		
		//4,判断用户是否有某一个权限
		boolean permitted = subject.isPermitted("user:query");
		System.out.println(username+"是否有user:query的权限:"+permitted);
		//5,分别判断用户是否有数组里面的权限
		String[] permissions= {"user:query","user:add","user:xxxx"};
		boolean[] permitted2 = subject.isPermitted(permissions);
		System.out.println("分别判断用户是否有数组里面的权限:"+Arrays.toString(permitted2));
		
		//6,判断用户是否有数组里面的所有权限
		boolean permittedAll = subject.isPermittedAll(permissions);
		System.out.println("判断用户是否有数组里面的所有权限:"+permittedAll);
		
		//7,
		boolean permitted3 = subject.isPermitted("user:*");
		System.out.println(permitted3);
		
		
		
		
		
		
		
		
		
	}
	
	

}
