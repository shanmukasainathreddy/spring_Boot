package com.prac.__MAR_USER_SERVICE.service;

import org.springframework.stereotype.Service;

import com.prac.__MAR_USER_SERVICE.entity.UserInformation;
import com.prac.__MAR_USER_SERVICE.repo.UserJpaRepository;

@Service
public class UserService {
	
	private UserJpaRepository jpa;
	
	public UserService(UserJpaRepository jpa) {
		this.jpa = jpa;
	}
	
	public String createUser(UserInformation info) {
		jpa.save(info);
		return "Data saved";
	}
	
	public UserInformation findUser(String emailId) {
		return jpa.findById(emailId).orElseThrow(()->new RuntimeException("Email not exist"));
	}
}
