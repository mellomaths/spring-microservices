package com.spring.microservices.photoapp.api.users.domain.users;

public interface UsersPasswordEncoder {
	
	String encode(String password);

}
