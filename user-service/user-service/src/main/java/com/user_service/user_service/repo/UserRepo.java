package com.user_service.user_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user_service.user_service.entity.UserInformation;

public interface UserRepo extends JpaRepository<UserInformation,String>  {
	

}
