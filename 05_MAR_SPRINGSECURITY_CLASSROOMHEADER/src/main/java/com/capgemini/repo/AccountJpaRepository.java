package com.capgemini.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.Account;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {
	
	public Optional<Account> findByUsername(String name);
	
	public boolean existsByUsername(String name);
	
	public boolean existByEmail(String email);
}
