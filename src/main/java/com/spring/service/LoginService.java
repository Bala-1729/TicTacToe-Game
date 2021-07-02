package com.spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.DAO.LoginDAO;
import com.spring.DAO.LoginDAO_hb;
import com.spring.model.Login;
import com.spring.model.Login_hb;

@Service
public class LoginService {
	public LoginService() {}

	public Map<String,String> login(Login_hb login) {
		LoginDAO_hb dao = new LoginDAO_hb();
		boolean loginStatus = dao.login(login);
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
