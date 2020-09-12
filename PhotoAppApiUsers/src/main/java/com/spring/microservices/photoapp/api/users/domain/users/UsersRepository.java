package com.spring.microservices.photoapp.api.users.domain.users;

import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

public interface UsersRepository {
	
	void save(UserDto userData);
	
	UserDto findById(String id) throws UserNotFoundException;
	
	UserDto findByEmail(String email) throws UserNotFoundException;

}
