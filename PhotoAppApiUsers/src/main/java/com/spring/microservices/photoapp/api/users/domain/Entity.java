package com.spring.microservices.photoapp.api.users.domain;

import com.spring.microservices.photoapp.api.users.domain.valueobjects.Identifier;

public class Entity {
	
	Identifier id;
	
	public Entity() {
		this.id = new Identifier();
	}

}
