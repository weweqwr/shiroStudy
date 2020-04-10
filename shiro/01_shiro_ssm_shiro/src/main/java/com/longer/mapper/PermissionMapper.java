package com.longer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.longer.pojo.Permission;


public interface PermissionMapper {
	
	//根据Id查询用户拥有的权限
	List<Permission> queryPermissionsByUserId(@Param("userid")Integer userid);
}