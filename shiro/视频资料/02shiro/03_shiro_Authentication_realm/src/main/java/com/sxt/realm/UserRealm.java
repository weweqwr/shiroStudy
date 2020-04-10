package com.sxt.realm;

import java.util.Arrays;
import java.util.Date;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;

import com.sxt.domain.User;
import com.sxt.service.UserService;
import com.sxt.service.impl.UserServiceImpl;


public class UserRealm extends AuthenticatingRealm{

	
	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	private UserService userService=new UserServiceImpl();

	
	
	/**
	 * 完成认证的方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username=token.getPrincipal().toString();
		Object credentials = token.getCredentials();//用户登陆时传过来的
		System.out.println(Arrays.toString((char[])credentials));
		//根据用户名查询用户是否存在
		User user=this.userService.queryUserByUserName(username);
		//返回null说明用户不存在
		if(null!=user) {
			/**
			 * 参数1  用户身份
			 * 参数2 用户在数据库里面存放的密码
			 * 参数3 当前类名
			 */
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
//			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName)
			
			return info;
			
		}
		return null;
	}

}
