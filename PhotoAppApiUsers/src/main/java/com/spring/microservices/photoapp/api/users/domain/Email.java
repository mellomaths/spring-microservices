package com.spring.microservices.photoapp.api.users.domain;

import java.io.Serializable;

public class Email implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@javax.validation.constraints.Email
	private final String value;
	
	public Email(String email) {
		this.value = email;
	}
	
	public static Email of(String value) {
		return new Email(value);
	}
	
	@Override
	public String toString() {
		return value;
	}

}
