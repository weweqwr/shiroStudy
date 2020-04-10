package com.longer.realm;

import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.longer.pojo.User;
import com.longer.service.PermissionService;
import com.longer.service.RoleService;
import com.longer.service.UserService;
import com.longer.utils.ActiveUser;

public class UserRealm extends AuthorizingRealm {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getClass().getSimpleName();
	}
	
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private RoleService roleService;
	/**
	 * �����֤�ķ���
	 *�Զ���Realm
	 */
	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
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
			List<String> roles= roleService.queryRolesByUserId(user.getUserid());
			//�����û�����ѯ�û�ӵ����ЩȨ��
			List<String> permissions=this.permissionService.queryPermissionsByUserId(user.getUserid());
			ActiveUser activeUser=new ActiveUser(user, roles, permissions);
			//ƥ������
			/*
			 * ����1 �û����
			����2	�û������ݿ������ŵ�����
			��ǰ����
			����3*/
			//SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(activeUser,user.getPassword(),this.getName());
			/**
			 * ����1������doGetAuthorizationInfo����getPrimaryPrinncipal()�Ķ������subject.getPrincipal()
			 * ����2��hashedCredentials����֮�������
			 * ����3����
			 * */
			ByteSource credentialsSalt=ByteSource.Util.bytes(user.getUsername()+user.getAddress());//�û����͵�ַ��Ϊ��
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(activeUser, user.getUserpwd(), credentialsSalt,this.getName());
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
				
		ActiveUser activeUser =(ActiveUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
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
		System.out.println(info);
		
		return info;
	}

}
