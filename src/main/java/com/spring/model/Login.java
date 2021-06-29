package com.spring.model;

import org.springframework.stereotype.Component;

@Component
public class Login {

	private String username;
	private String password;
	private Status status = new Status();

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Login() {
	}
}
