package com.prac.__MAR_USER_SERVICE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prac.__MAR_USER_SERVICE.entity.UserInformation;
import com.prac.__MAR_USER_SERVICE.service.UserService;

@Controller
public class UserController {
	private UserService service;
	
	public UserController(UserService service) {
			super();
			this.service = service;
	}
	
	@PostMapping("/create")
	public String create(UserInformation info) {
		return service.createUser(info);
	}
	
	@GetMapping("/{email}")
	public UserInformation findById(@PathVariable String email) {
		return service.findUser(email);
	}
}
