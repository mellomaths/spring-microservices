package com.spring.microservices.photoapp.api.users.domain.repository;

import com.spring.microservices.photoapp.api.users.shared.UserDto;

public interface UserRepository {
	
	void save(UserDto userData);

}
