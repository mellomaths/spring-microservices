package com.spring.microservices.photoapp.api.users.domain.users;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersAuthenticationService extends UserDetailsService {
	
	String generateAuthenticationToken(String email, String password);
	
	String generateJsonWebToken(UserDto userData);

}
