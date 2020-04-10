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
		//���÷�����ȡ����
		return this.getClass().getSimpleName();
	}
	
	private UserService userService=new UserServiceImpl();
	
	/**
	 * �����֤�ķ���
	 *�Զ���Realm
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username=token.getPrincipal().toString();
		Object credentials=token.getCredentials();//�û�������������
		System.out.println(Arrays.toString((char[])credentials));
		//credentials.�����û�����ѯ�û��Ƿ����
		User user=this.userService.queryUserByUserName(username);
		
		
		//����null˵���û�������
		if(null!=user){
			//ƥ������
			/*
			 * ����1 �û����
			����2	�û������ݿ������ŵ�����
			��ǰ����
			����3*/
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(new Date(),user.getPassword(),this.getName());
			return info;	
		}
		return null;
	}

}
