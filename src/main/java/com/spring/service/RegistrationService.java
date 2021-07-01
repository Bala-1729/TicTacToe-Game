package com.spring.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.DAO.UserDAO;
import com.spring.DAO.UserDAO_hb;
import com.spring.model.User;
import com.spring.model.User_hb;

@Service
public class RegistrationService {

	public RegistrationService() {}

	@Autowired
	UserDAO_hb dao = new UserDAO_hb();

	public Map<String, String> registerUser(User_hb user) {
		
		boolean regStatus = dao.register(user);
		Map<String, String> map = new HashMap<>();
		map.put("status", String.valueOf(regStatus));
		if (regStatus) {
			map.put("true", "/Game/home");
		} else {
			map.put("false", "Username already exists!!");
		}

		return map;
	}

}
