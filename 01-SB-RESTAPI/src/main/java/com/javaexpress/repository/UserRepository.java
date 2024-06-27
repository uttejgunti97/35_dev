package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	// DSL Methods
	User findByname(String name);
	
	User findByEmail(String email);
	
	//User findBynameOrEmail(String name,String email);
	
	User findBynameAndPassword(String name, String password);


}
