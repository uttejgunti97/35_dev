package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.entity.User;
import com.javaexpress.service.UserService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		log.info("UserController :: createuser {} ",user.getEmail());
	
		userService.createUser(user);
		}
	
	@GetMapping("{userId}")
	public User getUserById(@PathVariable Long userId) {
		log.info("UserController :: getUserById {} ",userId);
		return userService.findById(userId);
		
	}
	
	@PutMapping("{userId}")
	public void updateUser(@PathVariable Long userId,@RequestBody User user) {
		log.info("UserController :: updateUser {} ",userId);
		userService.updateUser(userId, user);
		}
	
	@DeleteMapping("{userId}")
	public void deleteUser(@PathVariable Long userId) {
		log.info("UserController :: deleteUser {} ",userId);
		userService.deleteUser(userId);
		}
	
	@GetMapping("/login/{name}/{password}")
	public User fetchUser(@PathVariable String name, @PathVariable String password) {
		log.info("UserController :: fetchUser {}", name);
		return userService.fetchUserDetails(name,password);
		
	}
	
	@GetMapping("/getname/{name}")
	public User findByname(@PathVariable String name) {
		log.info("UserController :: findByname {}" ,name);
		return userService.findByname(name);
		
	}
	
	@GetMapping("/getemail/{email}")
	public User findByEmail(@PathVariable String email) {
		log.info("UserController :: findByemail {}", email);
		return userService.findByEmail(email);
		}
}
