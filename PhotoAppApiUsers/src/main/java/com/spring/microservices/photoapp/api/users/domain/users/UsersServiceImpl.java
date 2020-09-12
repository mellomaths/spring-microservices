package com.spring.microservices.photoapp.api.users.domain.users;

import org.springframework.stereotype.Service;

import com.spring.microservices.photoapp.api.users.domain.User;
import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

@Service
public class UsersServiceImpl implements UsersService {
	
	private final UsersRepository userRepository;
	
	public UsersServiceImpl(final UsersRepository userRepository) {
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