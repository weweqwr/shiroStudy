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
		//调用方法获取类名
		return this.getClass().getSimpleName();
	}
	

	private UserService userService=new UserServiceImpl();
	
	private RoleService roleService=new RoleServiceImpl();
	
	private PermissionService permissionService=new PermissionServiceImpl();
	
	
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
			//更具用户名去查询用户拥有哪些角色
			List<String>roles= roleService.queryRoleByUserName(user.getUsername());
			//根据用户名查询用户拥有哪些权限
			List<String> permissions=this.permissionService.quertPermissionByUserName(user.getUsername());
			ActiveUser activeUser=new ActiveUser(user, roles, permissions);
			//匹配密码
			/*
			 * 参数1 用户身份
			参数2	用户在数据库里面存放的密码
			当前类名
			参数3*/
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(activeUser,user.getPassword(),this.getName());
			return info;	
		}
		return null;
	}
	/**
	 * 授权
	 *每次一判断权限授权啥的就会调用，真实场景会加入数据库，可能会导致数据库崩溃
	 *解决方法，在认证的时候把东西存在动态实体类中，
	 *授权的时候调用认证的时候存取在动态实体类里面的实体类
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		// TODO Auto-generated method stub
		ActiveUser activeUser =(ActiveUser) principals.getPrimaryPrincipal();
		if(activeUser.getUser().getType()==0){
			info.addStringPermission("*:*");
		}else{
			//更具用户名去查询用户拥有哪些角色
			List<String>roles= activeUser.getRoles();
			if(null!=roles&&roles.size()>0){
				//添加角色
				info.addRoles(roles);
			}
			
			//根据用户名查询用户拥有哪些权限
			List<String> permissions=activeUser.getPermissions();
			
			//添加权限
			if(null!=permissions&&permissions.size()>0){
				//添加角色 
				info.addStringPermissions(permissions);
			}
		}
		
		return info;
	}
	

}
