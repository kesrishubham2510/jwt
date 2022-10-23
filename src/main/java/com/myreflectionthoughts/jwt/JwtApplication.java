package com.myreflectionthoughts.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(scanBasePackages = {"com.myreflectionthoughts.jwt.*"}, exclude = {SecurityAutoConfiguration.class})
@ConfigurationPropertiesScan("com.myreflectionthoughts.jwt.*")
@ComponentScan(basePackages = {"com.myreflectionthoughts"})

public class JwtApplication {
	
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(JwtApplication.class, args);
	}	

	@Bean
	public PasswordEncoder passwordEncode(){
		return new BCryptPasswordEncoder();
	}
}
