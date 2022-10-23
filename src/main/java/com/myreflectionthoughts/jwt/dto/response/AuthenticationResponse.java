package com.myreflectionthoughts.jwt.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthenticationResponse {
	private String authToken;
	private String username;
	private String userId;
}
