package com.spring.microservices.photoapp.api.users.domain.users.exception;

public class UserNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String userId;
	
	public UserNotFoundException(String userId) {
		super("User " + userId + " was not found.");
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
	
}
