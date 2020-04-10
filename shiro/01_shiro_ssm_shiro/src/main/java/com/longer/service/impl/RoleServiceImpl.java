package com.longer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longer.mapper.RoleMapper;
import com.longer.pojo.Role;
import com.longer.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	public List<String> queryRolesByUserId(Integer userid) {
		List<Role> roleList=roleMapper.queryRolesByUserId(userid);
		List<String> roles=new ArrayList<String>();
		for (Role role : roleList) {
			roles.add(role.getRolename());
		}
		return roles;
	}

	
}
