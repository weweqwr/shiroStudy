package com.longer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.longer.pojo.Role;

public interface RoleMapper {
	//����Id��ѯ�û��Ľ�ɫ
	List<Role> queryRolesByUserId(@Param("userid")Integer userid);
}