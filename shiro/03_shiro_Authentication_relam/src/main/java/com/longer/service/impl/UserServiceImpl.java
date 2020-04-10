package com.longer.service.impl;

import java.util.Date;

import com.longer.pojo.User;
import com.longer.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User queryUserByUserName(String username) {
		User user=null;
		switch(username){
		case "admin":
			user=new User("admin","123456","管理员","武汉",new Date(),0);
			break;
		case "zhansan":
			user=new User("zhansan","123456","张三","武汉",new Date(),1);
			break;
		case "lisi":
			user=new User("lisi","123456","李四","武汉",new Date(),1);
			break;
		case "wangwu":
			user=new User("wangwu","123456","王五","武汉",new Date(),1);
			break;
		case "zhaoliu":
			user=new User("zhaoliu","123456","赵六","武汉",new Date(),1);
			break;
			
		}
		// TODO Auto-generated method stub
		return user;
	}

}
