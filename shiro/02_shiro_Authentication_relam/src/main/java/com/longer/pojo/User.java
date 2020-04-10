package com.longer.pojo;

import java.util.Date;

public class User {
	private String username;
	private String password;
	private String realname;
	private String address;
	private Date hiredate;
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, String realname, String address, Date hiredate) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.address = address;
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", realname=" + realname + ", address="
				+ address + ", hiredate=" + hiredate + "]";
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
	
}
