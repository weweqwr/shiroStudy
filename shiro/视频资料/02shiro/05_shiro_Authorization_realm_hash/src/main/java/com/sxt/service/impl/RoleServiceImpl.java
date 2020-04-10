package com.sxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sxt.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Override
	public List<String> queryRolesByUserName(String username) {
		List<String> roles=new ArrayList<>();
		roles.add("role1");
		roles.add("role2");
		roles.add("role3");
		return roles;
	}

}
