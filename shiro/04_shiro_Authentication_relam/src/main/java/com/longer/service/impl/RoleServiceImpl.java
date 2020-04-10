package com.longer.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.longer.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Override
	public List<String> queryRoleByUserName(String username) {
		List<String> roles=new ArrayList<>();
		roles.add("role1");
		roles.add("role2");
		roles.add("role3");
		return roles;
	}

}
