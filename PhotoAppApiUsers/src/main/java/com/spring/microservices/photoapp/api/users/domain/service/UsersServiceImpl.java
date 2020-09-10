package com.spring.microservices.photoapp.api.users.domain.service;

import org.springframework.stereotype.Service;

import com.spring.microservices.photoapp.api.users.domain.User;
import com.spring.microservices.photoapp.api.users.domain.exception.UserNotFoundException;
import com.spring.microservices.photoapp.api.users.domain.repository.UserRepository;
import com.spring.microservices.photoapp.api.users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService {
	
	private final UserRepository userRepository;
	
	public UsersServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public String createUser(UserDto userData) {
		User user = User.of(userData);
		userRepository.save(user.toDto());
		return user.getId().toString();
	}
	
	@Override
	public UserDto getUserById(String id) throws UserNotFoundException {
		UserDto user = userRepository.findById(id);
		return user;
	}
	
}
