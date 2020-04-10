package com.longer.shiro;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.longer.pojo.ActiveUser;
import com.longer.pojo.User;
import com.longer.service.PermissionService;
import com.longer.service.RoleService;
import com.longer.service.UserService;
import com.longer.service.impl.PermissionServiceImpl;
import com.longer.service.impl.RoleServiceImpl;
import com.longer.service.impl.UserServiceImpl;

public class UserRealm extends AuthorizingRealm {
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		//���÷�����ȡ����
		return this.getClass().getSimpleName();
	}
	

	private UserService userService=new UserServiceImpl();
	
	private RoleService roleService=new RoleServiceImpl();
	
	private PermissionService permissionService=new PermissionServiceImpl();
	
	
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
			//�����û���ȥ��ѯ�û�ӵ����Щ��ɫ
			List<String>roles= roleService.queryRoleByUserName(user.getUsername());
			//�����û�����ѯ�û�ӵ����ЩȨ��
			List<String> permissions=this.permissionService.quertPermissionByUserName(user.getUsername());
			ActiveUser activeUser=new ActiveUser(user, roles, permissions);
			//ƥ������
			/*
			 * ����1 �û����
			����2	�û������ݿ������ŵ�����
			��ǰ����
			����3*/
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(activeUser,user.getPassword(),this.getName());
			return info;	
		}
		return null;
	}
	/**
	 * ��Ȩ
	 *ÿ��һ�ж�Ȩ����Ȩɶ�ľͻ���ã���ʵ������������ݿ⣬���ܻᵼ�����ݿ����
	 *�������������֤��ʱ��Ѷ������ڶ�̬ʵ�����У�
	 *��Ȩ��ʱ�������֤��ʱ���ȡ�ڶ�̬ʵ���������ʵ����
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		// TODO Auto-generated method stub
		ActiveUser activeUser =(ActiveUser) principals.getPrimaryPrincipal();
		if(activeUser.getUser().getType()==0){
			info.addStringPermission("*:*");
		}else{
			//�����û���ȥ��ѯ�û�ӵ����Щ��ɫ
			List<String>roles= activeUser.getRoles();
			if(null!=roles&&roles.size()>0){
				//��ӽ�ɫ
				info.addRoles(roles);
			}
			
			//�����û�����ѯ�û�ӵ����ЩȨ��
			List<String> permissions=activeUser.getPermissions();
			
			//���Ȩ��
			if(null!=permissions&&permissions.size()>0){
				//��ӽ�ɫ 
				info.addStringPermissions(permissions);
			}
		}
		
		return info;
	}
	

}
