package com.spring.microservices.photoapp.api.users.domain.service;

import com.spring.microservices.photoapp.api.users.domain.User;
import com.spring.microservices.photoapp.api.users.shared.UserDto;

public class UsersServiceImpl implements UsersService {

	@Override
	public void createUser(UserDto userData) {
		// TODO Auto-generated method stub
		User user = User.of(userData);
		
	}
	
}
