package com.spring.microservices.photoapp.api.users.domain.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservices.photoapp.api.users.domain.User;
import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

@Service
public class UsersServiceImpl implements UsersService {
	
	private final UsersRepository userRepository;
	private final CreateUserFactory createUserFactory;

	@Autowired
	public UsersServiceImpl(final UsersRepository userRepository, final CreateUserFactory createUserFactory) {
		this.userRepository = userRepository;
		this.createUserFactory = createUserFactory;
	}

	@Override
	public String createUser(UserDto userData) {
		User user = createUserFactory.execute(userData);
		userRepository.save(user.toDto());
		return user.getId().toString();
	}
	
	@Override
	public UserDto getUserById(String id) throws UserNotFoundException {
		UserDto user = userRepository.findById(id);
		return user;
	}
	
	@Override
	public UserDto getUserByEmail(String email) throws UserNotFoundException {
		UserDto user = userRepository.findByEmail(email);
		return user;
	}
	
}
