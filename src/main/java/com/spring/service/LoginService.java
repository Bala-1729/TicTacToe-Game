package com.spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.DAO.LoginDAO;
import com.spring.model.Login;

@Service
public class LoginService {
	public LoginService() {}

	public Map<String,String> login(Login login) {
		LoginDAO dao = new LoginDAO();
		boolean loginStatus = dao.login(login.getUsername(), login.getPassword());
		Map<String, String> map = new HashMap<>();
		map.put("status", String.valueOf(loginStatus));
		
		if(loginStatus) {
			map.put("true", "/Game/home");
		}
		else {
			map.put("false", "Username and password doesn't match!");
		}
		return map;
	}
}
