package com.longer.shiro;

import java.util.Arrays;
import java.util.Date;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;

import com.longer.pojo.User;
import com.longer.service.UserService;
import com.longer.service.impl.UserServiceImpl;

public class UserRealm extends AuthenticatingRealm {
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		//调用方法获取类名
		return this.getClass().getSimpleName();
	}
	
	private UserService userService=new UserServiceImpl();
	
	/**
	 * 完成认证的方法
	 *自定义Realm
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username=token.getPrincipal().toString();
		Object credentials=token.getCredentials();//用户传过来的密码
		System.out.println(Arrays.toString((char[])credentials));
		//credentials.根据用户名查询用户是否存在
		User user=this.userService.queryUserByUserName(username);
		
		
		//返回null说明用户不存在
		if(null!=user){
			//匹配密码
			/*
			 * 参数1 用户身份
			参数2	用户在数据库里面存放的密码
			当前类名
			参数3*/
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(new Date(),user.getPassword(),this.getName());
			return info;	
		}
		return null;
	}

}
