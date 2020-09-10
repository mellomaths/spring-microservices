package com.spring.microservices.photoapp.api.users.domain.service;

import com.spring.microservices.photoapp.api.users.domain.exception.UserNotFoundException;
import com.spring.microservices.photoapp.api.users.shared.UserDto;

public interface UsersService {

	String createUser(UserDto userData);
	
	UserDto getUserById(String id) throws UserNotFoundException;
}
