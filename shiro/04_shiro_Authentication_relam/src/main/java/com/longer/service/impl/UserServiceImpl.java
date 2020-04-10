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
			user=new User("admin","a66abb5684c45962d887564f08346e8d","管理员","武汉",new Date(),0);
			break;
		case "zhansan":
			user=new User("zhansan","6aeab662e4a3aab2cc3c031214fa3369","张三","武汉",new Date(),1);
			break;
		case "lisi":
			user=new User("lisi","1b539b60601b934441308049a9526e7d","李四","武汉",new Date(),1);
			break;
		case "wangwu":
			user=new User("wangwu","d36e3f7de66577df5ba7660f8cd113c6","王五","武汉",new Date(),1);
			break;
		case "zhaoliu":
			user=new User("zhaoliu","112e536a5061405db34b9a5bbc42024a","赵六","武汉",new Date(),1);
			break;
			
		}
		// TODO Auto-generated method stub
		return user;
	}

}
