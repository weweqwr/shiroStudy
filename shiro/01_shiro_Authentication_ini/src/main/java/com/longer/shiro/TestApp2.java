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
 * �û���֤��Ȩ
 * **/
public class TestApp2 {
	public static void main(String[] args) {
		String username="along";
		String password="123456";
		//1������һ����ȫ�������Ĺ���
		//SecurityManager jdkҲ������࣬��java.lang��ע�ⲻҪʹ��jdk�����Ǹ���
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//2���ӹ�������õ�SecurityMnager
		SecurityManager securityManager=factory.getInstance();
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
		boolean permitted=subject.isPermitted("user:query");
		System.out.println(username+"�Ƿ���user:query��Ȩ��"+permitted);
		
		//5,���û��Ƿ������������Ȩ��
		String[] permissions={"user:query","user:add","user:xxx"};
		boolean[] permitted2=subject.isPermitted(permissions);
		System.out.println("�ֱ��ж��û��Ƿ������������Ȩ��"+Arrays.toString(permitted2));
		
		//6�ж��û��Ƿ����������������Ȩ��
		boolean permittedAll=subject.isPermittedAll(permissions);
		System.out.println("�ж��û��Ƿ����������������Ȩ��"+permittedAll);
		
		
		//7��
		boolean permitted3= subject.isPermitted("*:*");
		System.out.println(permitted3);
		
	}
}
