package com.myreflectionthoughts.jwt.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.myreflectionthoughts.jwt.repositories.UserRepository;
import com.myreflectionthoughts.jwt.security.JwtTokenFilter;
import com.myreflectionthoughts.jwt.security.userservice.UserDetailsImpl;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	/**
	 * UserDetailsService must implemet the UserDetailsService
	 */
	
	@Autowired
	PasswordEncoder passwordEncoder;
	 
	@Autowired
	JwtTokenFilter jwtTokenFilter;
	 
	@Autowired
	UserRepository userRepository;

	/**
	 * the method helps to configure the authentication
	 * @param auth
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService( username-> UserDetailsImpl.build(userRepository.findByUserName(username))).passwordEncoder(passwordEncoder);		
	}

	


	/**
	 * This method is used to configure which endpoints require authentication and which do not
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		//  .exceptionHandling()
		//  .authenticationEntryPoint(
		// 	 (request, response, ex) -> {
		// 		 response.sendError(
		// 			 HttpServletResponse.SC_UNAUTHORIZED,
		// 			 ex.getMessage()
		// 		 );
		// 	 }
		//  )
         http.cors().and().csrf().disable()
		 .sessionManagement()
		 .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		 .authorizeRequests().antMatchers("/authenticate/login").permitAll()
		 .anyRequest().authenticated();

		 // Add JWT token filter
		 http.addFilterBefore(
			 jwtTokenFilter,
			 UsernamePasswordAuthenticationFilter.class
		 );
	}


	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
}
