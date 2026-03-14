package com.user_service.user_service.Service;

import org.springframework.stereotype.Service;

import com.user_service.user_service.entity.UserInformation;
import com.user_service.user_service.repo.UserRepo;


@Service
public class UserService {
	
	UserRepo jpa;

	public UserService(UserRepo jpa) {
		this.jpa = jpa;
	}
	
	public String createUser(UserInformation info) {
		jpa.save(info);
		return "Data Saved";
	}
	
	
	public UserInformation findUser(String emailId) {
		return jpa.findById(emailId)
				  .orElseThrow(()->new RuntimeException("Email does not exist"));
		
	}
	

}
