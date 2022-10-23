package com.myreflectionthoughts.jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.myreflectionthoughts.jwt.dto.request.AuthenticationRequest;
import com.myreflectionthoughts.jwt.dto.response.AuthenticationResponse;
import com.myreflectionthoughts.jwt.entity.User;
import com.myreflectionthoughts.jwt.security.JwtTokenUtil;
import com.myreflectionthoughts.jwt.security.userservice.UserDetailsImpl;

@Service
public class AuthenticationService{
	
	// to start process of authentication
	@Autowired
	AuthenticationManager authenticationManager;


	// To generate the token after successfull authentication
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest){

		Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
		String authenticationToken = jwtTokenUtil.generateJwtToken(user);
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();
		authenticationResponse.setUserId(user.getUserId());
		authenticationResponse.setAuthToken(authenticationToken);
		authenticationResponse.setUsername(user.getUserName());
		return authenticationResponse;
	}

}
