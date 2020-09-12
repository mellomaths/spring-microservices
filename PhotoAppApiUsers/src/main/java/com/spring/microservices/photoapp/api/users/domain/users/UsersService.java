package com.spring.microservices.photoapp.api.users.domain.users;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

public interface UsersService extends UserDetailsService {

	String createUser(UserDto userData);
	
	UserDto getUserById(String id) throws UserNotFoundException;
	
	UserDto getUserByEmail(String email) throws UserNotFoundException;
	
	String generateAuthenticationToken(String email, String password);

}
