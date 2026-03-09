package com.prac.__MAR_USER_SERVICE.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.__MAR_USER_SERVICE.entity.UserInformation;

public interface UserJpaRepository extends JpaRepository<UserInformation, String>{

}