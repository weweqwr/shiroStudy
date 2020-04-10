package com.longer.mapper;

import org.apache.ibatis.annotations.Param;

import com.longer.pojo.User;


public interface UserMapper {
   //根据用户名查询用户
	User queryUserByUserName(@Param("username")String username);
}