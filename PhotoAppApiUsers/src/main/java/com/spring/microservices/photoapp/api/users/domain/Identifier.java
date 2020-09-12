package com.spring.microservices.photoapp.api.users.domain;

import java.io.Serializable;
import java.util.UUID;

public class Identifier implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final UUID value;
	
	public Identifier() {
		value = UUID.randomUUID();
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

}
