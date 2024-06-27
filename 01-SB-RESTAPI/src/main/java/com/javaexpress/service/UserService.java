package com.javaexpress.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.entity.User;
import com.javaexpress.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;

	public void createUser(User user) {
		log.info("UserService :: createUser {} {}", user.getName(), user.getEmail());
		userRepository.save(user);
		log.info("User succesfully saved in db");

	}

	public List<User> fetchAllUsers() {
		log.info("UserService :: fetchAllUsers");
		List<User> userList = userRepository.findAll();
		var result = userList.stream().sorted(Comparator.comparing(User::getName)).toList();
		return result;

	}

	public User findById(Long userId) {
		log.info("UserService :: findById {}", userId);

		return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not Found"));

	}

	public void updateUser(Long userId, User inputUser) {
		log.info("UserService :: updateUser {}", userId);
		User dbUser = findById(userId);
		dbUser.setName(inputUser.getName());
		dbUser.setEmail(inputUser.getEmail());
		dbUser.setPassword(inputUser.getPassword());
		userRepository.save(dbUser);

	}

	public void deleteUser(Long userId) {
		log.info("UserService :: deleteUser");
		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
		} else {
			throw new RuntimeException("User not found");

		}

	}

	public User fetchUserDetails(String name, String password) {
		log.info("UserService :: fetchUserDetails {}", name);
		return userRepository.findBynameAndPassword(name, password);
	}

	public User findByname(String name) {
		log.info("UserService :: findByname {}", name);
		return userRepository.findByname(name);
	}

	public User findByEmail(String email) {
		log.info("UserService :: findByemail {}", email);
		return userRepository.findByEmail(email);

	}

	/*
	 * public User fetchBynameOrEmail(String name, String email) {
	 * log.info("UserService :: findBynameOrEmail {} {}", name, email);
	 * 
	 * return userRepository.findBynameOrEmail(name, email);
	 * 
	 * }
	 */

}
