package com.sxt.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("user")
public class UserController {

	
	@RequestMapping("loadAllUser")
	public String loadAllUser() {
		return "list";
	}
}
