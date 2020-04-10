package com.longer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longer.mapper.UserMapper;
import com.longer.pojo.User;
import com.longer.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User queryUserByUserName(String username) {
		User user=userMapper.queryUserByUserName(username);
		return user;
	}
	

}
