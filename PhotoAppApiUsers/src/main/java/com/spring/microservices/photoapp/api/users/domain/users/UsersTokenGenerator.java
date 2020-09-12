package com.spring.microservices.photoapp.api.users.domain.users;

public interface UsersTokenGenerator {
	
	String generate(String email, String password);

}
