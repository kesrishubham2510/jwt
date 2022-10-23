package com.myreflectionthoughts.jwt.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myreflectionthoughts.jwt.dto.request.AuthenticationRequest;
import com.myreflectionthoughts.jwt.entity.User;
import com.myreflectionthoughts.jwt.enums.UserRole;
import com.myreflectionthoughts.jwt.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	
	@PostMapping("/login")
	public String authenticateUser(@Valid @RequestBody AuthenticationRequest authenticationRequest){
	    System.out.println("fkvbkvtgbvkrj");
		return  "from USer controller:- Loging In....";
	}

	@PostMapping("/create")
	public void createDummyUsers(){
		
		User user1 = new User();
		user1.setUserName("Shubham Kesri");
		user1.setPassword(passwordEncoder.encode("Shubham@123"));
		user1.setRole(UserRole.USER);
		
		User user2 = new User();
		user2.setUserName("Rachit yadav");
		user2.setPassword(passwordEncoder.encode("Rachit@123"));
		user2.setRole(UserRole.USER);

		User user3 = new User();
		user3.setUserName("Abhishek Yadav");
		user3.setPassword(passwordEncoder.encode("Abhishek@123"));
		user3.setRole(UserRole.USER);
		
		User user4 = new User();
		user4.setUserName("Rajesh Kesri");
		user4.setPassword(passwordEncoder.encode("Rajesh@123"));
		user4.setRole(UserRole.ADMIN);
		
		User user5 = new User();
		user5.setUserName("Santosh");
		user5.setPassword(passwordEncoder.encode("Santosh@123"));
		user5.setRole(UserRole.ADMIN);
		
		User user6 = new User();
		user6.setUserName("Kavita singh");
		user6.setPassword(passwordEncoder.encode("Kavita@123"));
		user6.setRole(UserRole.USER);
		
		User user7 = new User();
		user7.setUserName("Babita Iyer");
		user7.setPassword(passwordEncoder.encode("Babita@123"));
		user7.setRole(UserRole.STAFF);

		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		users.add(user7);
	
		userService.saveUsers(users);
		
	}

}
