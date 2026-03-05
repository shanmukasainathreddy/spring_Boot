package com.capgemini;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, String> {
	
	 Employee findByEmailAndPassword(String email,String password);
		
	}
