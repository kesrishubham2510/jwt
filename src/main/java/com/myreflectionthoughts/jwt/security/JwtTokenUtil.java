package com.myreflectionthoughts.jwt.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.myreflectionthoughts.jwt.entity.User;
import com.myreflectionthoughts.jwt.security.userservice.UserDetailsImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
// This class generates the token
public class JwtTokenUtil {

	@Value("${jwt.expirationTime}")
	private long EXPIRE_DURATION; 
     
    @Value("${jwt.secret}")
    private String SECRET_KEY;

	// this function generates the JWT token
	public String generateJwtToken(User user){
		return Jwts.builder()
		           .setSubject(String.format("%s %s",user.getUserName(), user.getUserId()))
				   .setIssuer("myreflectionthoughts")
				   .setIssuedAt(new Date())
				   .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				   .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				   .compact();
	}

	public String getUsername(String token) {
		String[] subject = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject().split(" ");
		return subject[0];
	}     

	public boolean validate(String token){
		return true;
	}

	public String generateJwtToken(UserDetailsImpl user) {
		return Jwts.builder()
		           .setSubject(String.format("%s %s",user.getUserName(), user.getUserId()))
				   .setIssuer("myreflectionthoughts")
				   .setIssuedAt(new Date())
				   .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				   .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				   .compact();
	}
	
}
