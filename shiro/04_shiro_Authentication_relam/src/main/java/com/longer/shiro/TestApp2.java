package com.longer.shiro;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
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
		
		//�����Զ���ralam relam����ע�뵽��ȫ����������
		UserRealm realm=new UserRealm();//<bean
		//��������ѧ��صļ��ܷ�ʽ
		HashedCredentialsMatcher credenticalsMacher=new HashedCredentialsMatcher();//<bean
		//���ü��ܷ�ʽ
		credenticalsMacher.setHashAlgorithmName("md5");//<property
		//����ɢ�д���
		credenticalsMacher.setHashIterations(1);//<property
		//���Զ���realmע��ƾ֤ƥ����
		realm.setCredentialsMatcher(credenticalsMacher);//<property
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
				//2�û��Ƿ�ͬʱӵ�м�����������н�ɫ
				Collection<String> roleIdentifiers=new ArrayList<>();
				roleIdentifiers.add("role1");
				roleIdentifiers.add("role2");
				roleIdentifiers.add("role3");
				boolean allRoles=subject.hasAllRoles(roleIdentifiers);
				System.out.println(username+"roleIdentifiers������������н�ɫ"+allRoles);
				
				//3���ֱ��ж��û��Ƿ��м�������ý�ɫ
				boolean[] hasRoes=subject.hasRoles((List<String>) roleIdentifiers);
				System.out.println(hasRoes[0]?"ӵ��role1�ý�ɫ":"û��role1�����ɫ");
				System.out.println(hasRoes[1]?"ӵ��role2�ý�ɫ":"û��role2�����ɫ");
				System.out.println(hasRoes[2]?"ӵ��role3�ý�ɫ":"û��role3�����ɫ");
				System.out.println(Arrays.toString(hasRoes));
				//4,���û��Ƿ���ĳһȨ��
				boolean permitted=subject.isPermitted("dept:export");
				System.out.println(username+"�Ƿ���user:query��Ȩ��"+permitted);
				
				//5,���û��Ƿ������������Ȩ��
				String[] permissions={"user:query","user:add","user:xxx"};
				boolean[] permitted2=subject.isPermitted(permissions);
				System.out.println("�ֱ��ж��û��Ƿ������������Ȩ��"+Arrays.toString(permitted2));
				
				//6�ж��û��Ƿ����������������Ȩ��
				boolean permittedAll=subject.isPermittedAll(permissions);
				System.out.println("�ж��û��Ƿ����������������Ȩ��"+permittedAll);
	}
}
