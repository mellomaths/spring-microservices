package com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.microservices.photoapp.api.users.domain.repository.UserRepository;
import com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo.document.UserDocument;
import com.spring.microservices.photoapp.api.users.shared.UserDto;

@Component
@Primary
public class UserRepositoryMongoImpl implements UserRepository {

	private final SpringDataMongoUserRepository userRepository;

	@Autowired
	public UserRepositoryMongoImpl(final SpringDataMongoUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void save(UserDto userData) {
		System.out.println("Saving user " + userData.getId());
		userRepository.save(UserDocument.of(userData));
		
	}

}
