package com.spring.microservices.photoapp.api.users.domain.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.microservices.photoapp.api.users.domain.User;

@Component
@Primary
public class CreateUserFactory {
	
	@Autowired
	private UserPasswordEncoder passwordEncoder;
	
	public User execute(UserDto userData) {
		User user = User.of(userData);
		user.encryptPassword(passwordEncoder);
		return user;
	}

}
