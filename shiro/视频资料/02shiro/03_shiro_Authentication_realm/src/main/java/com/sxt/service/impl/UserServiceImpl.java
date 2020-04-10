package com.sxt.service.impl;

import java.util.Date;

import com.sxt.domain.User;
import com.sxt.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User queryUserByUserName(String username) {
		User user=null;
		switch (username) {
		case "zhangsan":
			user=new User("zhangsan", "123456", "张三", "武汉", new Date());
			break;
		case "lishi":
			user=new User("lishi", "123456", "李四", "武汉", new Date());
			break;
		case "wangwu":
			user=new User("wangwu", "123456", "王五", "武汉", new Date());
			break;
		case "zhaoliu":
			user=new User("zhaoliu", "123456", "赵六", "武汉", new Date());
			break;
		}
		return user;
	}

}
