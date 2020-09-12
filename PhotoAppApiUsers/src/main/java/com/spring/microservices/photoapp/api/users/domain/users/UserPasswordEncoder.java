package com.spring.microservices.photoapp.api.users.domain.users;

public interface UserPasswordEncoder {
	
	String encode(String password);

}
