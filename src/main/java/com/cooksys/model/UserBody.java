package com.cooksys.model;

public class UserBody {
	
	private String username;
	private String password;
	private Long num;
	private String admin;
	
	public UserBody() {

	}
	
	public UserBody(String username, String password, Long num, String admin) {
		this.username = username;
		this.password = password;
		this.num = num;
		this.admin = admin;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
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

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

}
