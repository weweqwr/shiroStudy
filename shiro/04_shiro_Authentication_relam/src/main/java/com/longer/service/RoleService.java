package com.longer.service;

import java.util.List;

public interface RoleService {
	/*根据用户名查询用户拥有的权限*/
	List<String> queryRoleByUserName(String username);

}
