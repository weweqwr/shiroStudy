package com.longer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longer.mapper.PermissionMapper;
import com.longer.pojo.Permission;
import com.longer.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{
	@Autowired
	private PermissionMapper permissionMapper;

	public List<String> queryPermissionsByUserId(Integer userid) {
		List<Permission> permissionList=permissionMapper.queryPermissionsByUserId(userid);
		List<String> permissions=new ArrayList<String>();
		
		for (Permission permission : permissionList) {
			permissions.add(permission.getPercode());
		}
		return permissions;
	}




	


}
