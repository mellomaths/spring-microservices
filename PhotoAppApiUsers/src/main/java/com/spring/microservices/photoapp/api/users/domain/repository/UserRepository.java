package com.spring.microservices.photoapp.api.users.domain.repository;

import com.spring.microservices.photoapp.api.users.domain.exception.UserNotFoundException;
import com.spring.microservices.photoapp.api.users.shared.UserDto;

public interface UserRepository {
	
	void save(UserDto userData);
	
	UserDto findById(String id) throws UserNotFoundException; 

}
