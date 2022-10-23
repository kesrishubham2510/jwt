package com.myreflectionthoughts.jwt.dto.request;

import javax.annotation.Generated;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class AuthenticationRequest {
	
	@NotBlank (message = "Username is required") 
	@Length (min = 5)
	private String userName;
	@NotBlank (message = "Password is required")
	private String password;	
}
