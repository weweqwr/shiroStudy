package com.longer.mapper;

import org.apache.ibatis.annotations.Param;

import com.longer.pojo.User;


public interface UserMapper {
   //�����û�����ѯ�û�
	User queryUserByUserName(@Param("username")String username);
}