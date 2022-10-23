package com.myreflectionthoughts.jwt.security.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.myreflectionthoughts.jwt.entity.User;
import com.myreflectionthoughts.jwt.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user  = userRepository.findByUserName(username);
		if(user==null)
		 throw new UsernameNotFoundException("!! User not found !!");
		return UserDetailsImpl.build(user);
	}
	
}
