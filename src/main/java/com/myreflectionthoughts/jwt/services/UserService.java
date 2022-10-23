package com.myreflectionthoughts.jwt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myreflectionthoughts.jwt.entity.User;
import com.myreflectionthoughts.jwt.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User createUser(User user){
		return userRepository.save(user);
	}

	public void saveUsers(List<User> users){
		userRepository.saveAll(users);
	}

}
