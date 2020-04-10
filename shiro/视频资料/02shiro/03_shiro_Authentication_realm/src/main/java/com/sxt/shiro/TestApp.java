package com.sxt.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import com.sxt.realm.UserRealm;

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
		DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
		
		//创建自定义realm 并注入到安全管理器里面
		Realm realm=new UserRealm();
		securityManager.setRealm(realm);
		
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
			Object object = subject.getPrincipal(); //得到doGetAuthenticationInfo的返回值SimpleAuthenticationInfo里面的第一个参数
			System.out.println(object);
			
		} catch (AuthenticationException e) {
			System.out.println("用户名或密码不正确");
		}
		
		//1,判断用户是否有某一个角色
		boolean hasRole1 = subject.hasRole("role1");
		boolean hasRole3 = subject.hasRole("role1");
		System.out.println(username+"是否有role1的角色:"+hasRole1);
		
	}
}
