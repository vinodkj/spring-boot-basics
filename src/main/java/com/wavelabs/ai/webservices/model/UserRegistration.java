package com.wavelabs.ai.webservices.model;

import java.io.Serializable;
import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFilter("userRegistration")
public class UserRegistration implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String userName;
	private String password;
	private String email;
	public UserRegistration(String name, String userName, String password, String email) {
		this.name = name;
		this.userName = userName;
		this.password = Base64.getEncoder().encodeToString(password.getBytes());
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
