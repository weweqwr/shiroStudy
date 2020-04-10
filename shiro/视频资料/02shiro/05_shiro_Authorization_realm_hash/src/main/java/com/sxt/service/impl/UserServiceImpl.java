package com.sxt.service.impl;

import java.util.Date;

import com.sxt.domain.User;
import com.sxt.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User queryUserByUserName(String username) {
		User user=null;
		switch (username) {
		case "admin":
			user=new User("admin", "928bfd2577490322a6e19b793691467e", "管理员", "武汉", new Date(),0);
			break;
		case "zhangsan":
			user=new User("zhangsan", "654407ac2e454fe560337510aa6adb97", "张三", "武汉", new Date(),1);
			break;
		case "lishi":
			user=new User("lishi", "c026eb3b2506668390c4a1c1b4417eb0", "李四", "武汉", new Date(),1);
			break;
		case "wangwu":
			user=new User("wangwu", "4d6a8546c786edaed7ec4858bee8975c", "王五", "武汉", new Date(),1);
			break;
		case "zhaoliu":
			user=new User("zhaoliu", "a33005a4ff1f4890efaee6f754259839", "赵六", "武汉", new Date(),1);
			break;
		}
		return user;
	}

}
