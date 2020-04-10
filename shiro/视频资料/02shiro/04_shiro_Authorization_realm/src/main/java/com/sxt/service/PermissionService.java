package com.sxt.service;

import java.util.List;


public interface PermissionService {
	
	/**
	 * 根据用户名查询用户拥有的权限
	 * @param username
	 * @return
	 */
	List<String> queryPermissionsByUserName(String username);

}
