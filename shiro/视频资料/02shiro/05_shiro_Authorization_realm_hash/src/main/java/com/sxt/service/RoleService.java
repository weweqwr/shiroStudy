package com.sxt.service;

import java.util.List;

public interface RoleService {

	/**
	 * 根据用户名查询用户拥有的角色
	 * @param username
	 * @return
	 */
	List<String> queryRolesByUserName(String username);

}
