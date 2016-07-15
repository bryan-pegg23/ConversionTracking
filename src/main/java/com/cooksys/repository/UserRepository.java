package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.UserApp;

public interface UserRepository extends JpaRepository<UserApp, Long>{

	public UserApp findByUsername(String username);
	
	public List<UserApp> findBySignupNum(Long num);
	
}
