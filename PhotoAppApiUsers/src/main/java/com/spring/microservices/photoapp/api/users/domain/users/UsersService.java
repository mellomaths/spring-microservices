package com.spring.microservices.photoapp.api.users.domain.users;

import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

public interface UsersService {

	String createUser(UserDto userData);
	
	UserDto getUserById(String id) throws UserNotFoundException;

}
