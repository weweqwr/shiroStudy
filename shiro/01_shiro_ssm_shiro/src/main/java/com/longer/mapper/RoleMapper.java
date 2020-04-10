package com.longer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.longer.pojo.Role;

public interface RoleMapper {
	//根据Id查询用户的角色
	List<Role> queryRolesByUserId(@Param("userid")Integer userid);
}