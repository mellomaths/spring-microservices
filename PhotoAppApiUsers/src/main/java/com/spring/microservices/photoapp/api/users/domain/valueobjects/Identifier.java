package com.spring.microservices.photoapp.api.users.domain.valueobjects;

import java.io.Serializable;
import java.util.UUID;

public class Identifier implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final UUID id;
	
	public Identifier() {
		id = UUID.randomUUID();
	}
	
	@Override
	public String toString() {
		return id.toString();
	}

}
