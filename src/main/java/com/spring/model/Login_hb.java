package com.spring.model;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="usertable")
public class Login_hb {

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="pass")
	private String password;
	
	@Transient
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

	public Login_hb() {}
}
