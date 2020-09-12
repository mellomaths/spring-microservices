package com.spring.microservices.photoapp.api.users.domain.users;

import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;
import com.spring.microservices.photoapp.api.users.shared.UserDto;

public interface UserRepository {
	
	void save(UserDto userData);
	
	UserDto findById(String id) throws UserNotFoundException; 

}
