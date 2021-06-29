package com.spring.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.DAO.UserDAO;
import com.spring.model.User;

@Service
public class RegistrationService {

	public RegistrationService() {}

	@Autowired
	UserDAO dao = new UserDAO();

	public Map<String, String> registerUser(User user) {
		boolean regStatus = dao.register(user.getFirstname(), user.getLastname(), user.getUsername(), user.getEmail(),
				user.getPassword());
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
