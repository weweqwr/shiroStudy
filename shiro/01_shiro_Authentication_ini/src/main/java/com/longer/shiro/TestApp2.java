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
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
/**
 * 
 * 用户验证授权
 * **/
public class TestApp2 {
	public static void main(String[] args) {
		String username="along";
		String password="123456";
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

		}catch(AuthenticationException e){
			//ctrl+t看类得继承关系
			System.out.println("用户名或密码不正确");
		}
		//1、判断用户是否有某一个角色
		boolean hasRole1=subject.hasRole("role1");
		System.out.println(username+"是否有role1得角色"+hasRole1);
		//2用户是否同时拥有集合里面得所有角色
		Collection<String> roleIdentifiers=new ArrayList<>();
		roleIdentifiers.add("role1");
		roleIdentifiers.add("role2");
		roleIdentifiers.add("role3");
		boolean allRoles=subject.hasAllRoles(roleIdentifiers);
		System.out.println(username+"roleIdentifiers集合里面得所有角色"+allRoles);
		
		//3、分别判断用户是否有集合里面得角色
		boolean[] hasRoes=subject.hasRoles((List<String>) roleIdentifiers);
		System.out.println(hasRoes[0]?"拥有role1该角色":"没有role1这个角色");
		System.out.println(hasRoes[1]?"拥有role2该角色":"没有role2这个角色");
		System.out.println(hasRoes[2]?"拥有role3该角色":"没有role3这个角色");
		System.out.println(Arrays.toString(hasRoes));
		//4,判用户是否有某一权限
		boolean permitted=subject.isPermitted("user:query");
		System.out.println(username+"是否有user:query得权限"+permitted);
		
		//5,判用户是否有数组里面的权限
		String[] permissions={"user:query","user:add","user:xxx"};
		boolean[] permitted2=subject.isPermitted(permissions);
		System.out.println("分别判断用户是否有数组里面的权限"+Arrays.toString(permitted2));
		
		//6判断用户是否有数组里面的所有权限
		boolean permittedAll=subject.isPermittedAll(permissions);
		System.out.println("判断用户是否有数组里面的所有权限"+permittedAll);
		
		
		//7，
		boolean permitted3= subject.isPermitted("*:*");
		System.out.println(permitted3);
		
	}
}
