package com.spring.microservices.photoapp.api.users.domain.users;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

@Service
public class UsersAuthenticationServiceImpl implements UsersAuthenticationService {
	
	private final UsersRepository userRepository;
	private final UsersTokenGenerator usersTokenGenerator;
	private final UsersJsonWebTokenGenerator usersJsonWebTokenGenerator;
	private final Environment env;
	
	@Autowired
	public UsersAuthenticationServiceImpl(final UsersRepository userRepository, final UsersTokenGenerator usersTokenGenerator, final UsersJsonWebTokenGenerator usersJsonWebTokenGenerator, final Environment env) {
		this.userRepository = userRepository;
		this.usersTokenGenerator = usersTokenGenerator;
		this.usersJsonWebTokenGenerator = usersJsonWebTokenGenerator;
		this.env = env;
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
	
	@Override
	public String generateJsonWebToken(UserDto userData) {
		String tokenSecret = env.getRequiredProperty("token.secret");
		Date expiration = new Date(System.currentTimeMillis() + Long.parseLong(env.getProperty("token.expiration", "3600000")));
		String jwt = this.usersJsonWebTokenGenerator.generateJwtBasedOnHS512Algorithm(userData.getId(), expiration, tokenSecret);
		return jwt;
	}
}
