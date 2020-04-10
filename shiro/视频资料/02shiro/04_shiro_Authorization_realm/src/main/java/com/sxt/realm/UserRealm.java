package com.sxt.realm;

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

import com.sxt.domain.User;
import com.sxt.service.PermissionService;
import com.sxt.service.RoleService;
import com.sxt.service.UserService;
import com.sxt.service.impl.PermissionServiceImpl;
import com.sxt.service.impl.RoleServiceImpl;
import com.sxt.service.impl.UserServiceImpl;


public class UserRealm extends AuthorizingRealm{

	
	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	private UserService userService=new UserServiceImpl();
	
	private RoleService roleService=new RoleServiceImpl();
	
	private PermissionService permssionService=new PermissionServiceImpl();

	
	
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
			//根据用户名去查询用户拥有哪些角色
			List<String> roles= roleService.queryRolesByUserName(user.getUsername());
			//根据用户名查询用户拥有哪些权限
			List<String> permissions=this.permssionService.queryPermissionsByUserName(user.getUsername());
			
			ActiveUser activeUser=new ActiveUser(user, roles, permissions);
			/**
			 * 参数1  用户身份
			 * 参数2 用户在数据库里面存放的密码
			 * 参数3 当前类名
			 */
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(activeUser, user.getPassword(), this.getName());
//			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName)
			
			return info;
			
		}
		return null;
	}



	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();
		System.out.println("doGetAuthorizationInfo");
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		if(activeUser.getUser().getType()==0) {
			info.addStringPermission("*:*");
		}else {
			//根据用户名去查询用户拥有哪些角色
			List<String> roles= activeUser.getRoles();
			if(null!=roles&&roles.size()>0) {
				//添加角色
				info.addRoles(roles);
			}
			//根据用户名查询用户拥有哪些权限
			List<String> permissions=activeUser.getPermissions();
			//添加权限
			if(null!=permissions&&permissions.size()>0) {
				//添加角色
				info.addStringPermissions(permissions);
			}
		}
		return info;
	}

}
