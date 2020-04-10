package com.longer.pojo;

import java.util.Date;

public class User {
	private String username;
	private String password;
	private String realname;
	private String address;
	private Date hiredate;
	
	private Integer type=1;//0超级管理员 1普通系统用户
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	


	public User(String username, String password, String realname, String address, Date hiredate, Integer type) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.address = address;
		this.hiredate = hiredate;
		this.type = type;
	}




	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", realname=" + realname + ", address="
				+ address + ", hiredate=" + hiredate + ", type=" + type + "]";
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
