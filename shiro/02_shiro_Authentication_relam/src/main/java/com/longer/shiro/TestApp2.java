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
 * �Զ���relamʵ����֤
 * 1������user
 * 2������UserService
 * 3������UserServiceImpl
 * 4������UserReaml
 * 5������������
 * **/
public class TestApp2 {
	public static void main(String[] args) {
		String username="zhansan";
		String password="123456";
		//1������һ����ȫ�������Ĺ���
		//SecurityManager jdkҲ������࣬��java.lang��ע�ⲻҪʹ��jdk�����Ǹ���
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//2���ӹ�������õ�SecurityMnager
		DefaultSecurityManager securityManager=(DefaultSecurityManager) factory.getInstance();
		
		Realm realm=new UserRealm();
		securityManager.setRealm(realm);
		
		//3���ѵ�ǰ��SecurityManager�󶨵���ǰ���߳�
		SecurityUtils.setSecurityManager(securityManager);
		//4,ȡ����ǰ��Subject
		Subject subject=SecurityUtils.getSubject();
		System.out.println(subject);
		//5����װ�û���������
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		try {
			//6�����е�¼��֤
			subject.login(token);
			System.out.println("�Ƿ���֤�ɹ�"+subject.isAuthenticated());//subject.isAuthenticated�ж��Ƿ���֤��
			Object object=subject.getPrincipal();//�õ�doGetAuthenticationInfo�ķŻ�ֵSimpleAuthenticateionInfo����ĵ�һ������
			System.out.println(object);
		}catch(AuthenticationException e){
			//ctrl+t����ü̳й�ϵ
			System.out.println("�û��������벻��ȷ");
		}
		//1���ж��û��Ƿ���ĳһ����ɫ
		boolean hasRole1=subject.hasRole("role1");
		System.out.println(username+"�Ƿ���role1�ý�ɫ"+hasRole1);
			
	}
}
