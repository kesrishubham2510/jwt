package com.myreflectionthoughts.jwt.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myreflectionthoughts.jwt.dto.request.AuthenticationRequest;
import com.myreflectionthoughts.jwt.dto.response.AuthenticationResponse;
import com.myreflectionthoughts.jwt.services.AuthenticationService;

@CrossOrigin
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	@Autowired
	AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> authenticateUser(@Valid @RequestBody AuthenticationRequest authenticationRequest){
	    System.out.println("fkvbkvtgbvkrj");
		// throw new Exception("Testing Exceptions");
		ResponseEntity<AuthenticationResponse> res = null;
		try {
	      res =	  ResponseEntity.status(HttpStatus.OK).body(authenticationService.authenticateUser(authenticationRequest));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return res;
	}

	// @PostMapping("/login")
	// public String authenticateUser(@Valid @RequestBody AuthenticationRequest authenticationRequest){
	//     System.out.println("fkvbkvtgbvkrj");
	// 	return  "Loging In....";
	// }
}