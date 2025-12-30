package com.example.AlisverisSitesi.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AlisverisSitesi.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

	
	User findByEmail(String email);
	
	
}
