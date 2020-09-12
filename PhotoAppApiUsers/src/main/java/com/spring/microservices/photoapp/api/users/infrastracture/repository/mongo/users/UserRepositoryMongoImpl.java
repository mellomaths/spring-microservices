package com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo.users;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.microservices.photoapp.api.users.domain.users.UserDto;
import com.spring.microservices.photoapp.api.users.domain.users.UsersRepository;
import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

@Component
@Primary
public class UserRepositoryMongoImpl implements UsersRepository {

	private final SpringDataMongoUserRepository userRepository;

	@Autowired
	public UserRepositoryMongoImpl(final SpringDataMongoUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void save(UserDto userData) {
		userRepository.save(UserDocument.of(userData));
	}
	
	@Override
	public UserDto findById(String id) throws UserNotFoundException {
		Optional<UserDocument> result = userRepository.findById(id);
		if (!result.isPresent()) {
			throw new UserNotFoundException(id);
		}
		
		UserDocument user = result.get();
		return user.toDto();		
	}

}
