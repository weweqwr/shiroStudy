package com.longer.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
/**
 * �û���֤
 * **/
public class TestAPP {
	public static void main(String[] args) {
		String username="zhansan";
		String password="1234563";
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
//		} catch (IncorrectCredentialsException e) {
//			// TODO Auto-generated catch block
//			System.out.println("���벻��ȷ");
//		}catch (UnknownAccountException e) {
//			// TODO Auto-generated catch block
//			System.out.println("�û�������ȷ");
//		}
		}catch(AuthenticationException e){
			//ctrl+t����ü̳й�ϵ
			System.out.println("�û��������벻��ȷ");
		}
		
//		a();
//		b();
//		ThreadLocal<Subject> xxx=new ThreadLocal<>();
//		xxx.get();
//		xx.set();
	}
	static void a(){
		Subject subject=SecurityUtils.getSubject();
		System.out.println(subject);
	}
	static void b(){
		Subject subject=SecurityUtils.getSubject();
		System.out.println(subject);
	}

}
