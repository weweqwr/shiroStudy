package com.sxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sxt.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {

	@Override
	public List<String> queryPermissionsByUserName(String username) {
		List<String> permissions=new ArrayList<String>();
		permissions.add("user:query");
		permissions.add("user:add");
		permissions.add("user:update");
		permissions.add("user:delete");
		permissions.add("user:export");
		permissions.add("dept:query");
		return permissions;
	}

}
