package com.myreflectionthoughts.jwt.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.myreflectionthoughts.jwt.enums.UserRole;

import lombok.Data;

@Document(collection = "users")
@Data
public class User {
	
	@Id
	private String userId;
	private String userName;
	private String password;
	private UserRole role;
}
