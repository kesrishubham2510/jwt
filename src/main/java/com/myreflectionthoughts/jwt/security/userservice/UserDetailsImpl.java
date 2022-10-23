package com.myreflectionthoughts.jwt.security.userservice;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myreflectionthoughts.jwt.entity.User;

public class UserDetailsImpl implements UserDetails{

	private String username;
	private String userId;

	public String getUserId() {
		return userId;
	}

	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;


	

	// Constructor
	public UserDetailsImpl(String username, String userId,String password,Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.userId = userId;
		this.authorities = authorities;
		this.password = password;
	}

	// build method to build userDetailsImpl object from User object

	public static UserDetailsImpl build(User user){
		List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority(user.getRole().name()));
		return new UserDetailsImpl(user.getUserName(), user.getUserId(), user.getPassword(),grantedAuthorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public String getUserName(){
		return this.username;
	}

	/**
	 * This method returns the value is uniquely indexed in database
	*/
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
