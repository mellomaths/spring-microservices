package com.spring.microservices.photoapp.api.users.domain.users;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.microservices.photoapp.api.users.domain.User;
import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

@Service
public class UsersServiceImpl implements UsersService {
	
	private final UsersRepository userRepository;
	private final CreateUserFactory createUserFactory;
	private final UsersTokenGenerator usersTokenGenerator;

	@Autowired
	public UsersServiceImpl(final UsersRepository userRepository, final CreateUserFactory createUserFactory, final UsersTokenGenerator usersTokenGenerator) {
		this.userRepository = userRepository;
		this.createUserFactory = createUserFactory;
		this.usersTokenGenerator = usersTokenGenerator;
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserDto user = userRepository.findByEmail(username);
			return new org.springframework.security.core.userdetails.User(
					user.getEmail(), user.getPassword(), true, true, true, true, new ArrayList<>());
		} catch (UserNotFoundException err) {
			throw new UsernameNotFoundException(err.getMessage());
		}
	}

	@Override
	public String generateAuthenticationToken(String email, String password) {
		return usersTokenGenerator.generate(email, password);
	}
	
}
