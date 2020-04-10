package com.longer.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.longer.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {

	@Override
	public List<String> quertPermissionByUserName(String username) {
		List<String> permissions=new ArrayList<String>();
		permissions.add("user:query");
		permissions.add("user:add");
		permissions.add("user:update");
		permissions.add("user:delete");
		permissions.add("dept:export");
		
		return permissions;
	}

}
