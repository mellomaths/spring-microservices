package com.spring.microservices.photoapp.api.users.application.http.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.microservices.photoapp.api.users.application.http.users.LoginUserRequestBody;
import com.spring.microservices.photoapp.api.users.domain.users.UserDto;
import com.spring.microservices.photoapp.api.users.domain.users.UsersAuthenticationService;
import com.spring.microservices.photoapp.api.users.domain.users.UsersService;
import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private UsersService usersService;
	private UsersAuthenticationService usersAuthenticationService;
	
	public AuthenticationFilter(UsersService userService, UsersAuthenticationService usersAuthenticationService, AuthenticationManager authenticationManager) {
		this.usersService = userService;
		this.usersAuthenticationService = usersAuthenticationService;
		super.setAuthenticationManager(authenticationManager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {
			LoginUserRequestBody credentials = new ObjectMapper()
					.readValue(request.getInputStream(), LoginUserRequestBody.class);
			return getAuthenticationManager()
					.authenticate(
						new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword(), new ArrayList<>())
					);
			
		} catch (IOException err) {
			throw new RuntimeException(err);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
		User userAuthPrincipal = (User) auth.getPrincipal();
		try {
			UserDto userData = usersService.getUserByEmail(userAuthPrincipal.getUsername());
			String jwt = usersAuthenticationService.generateJsonWebToken(userData);
			response.addHeader("access_token", jwt);
			response.addHeader("user_id", userData.getId());
		} catch (UserNotFoundException ex) {
			
		}
	}

}
