package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserApp")
public class UserApp {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	@Column(name = "signupNum")
	private Long signupNum;
	
	@Column(name = "admin")
	private String admin;

	public UserApp() {

	}

	public UserApp(Long id, String username, String password, String admin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public Long getSignupNum() {
		return signupNum;
	}

	public void setSignupNum(Long signupNum) {
		this.signupNum = signupNum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
