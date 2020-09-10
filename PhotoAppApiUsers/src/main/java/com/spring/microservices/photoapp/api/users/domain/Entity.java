package com.spring.microservices.photoapp.api.users.domain;

import com.spring.microservices.photoapp.api.users.domain.valueobjects.Date;
import com.spring.microservices.photoapp.api.users.domain.valueobjects.Identifier;

public class Entity {
	
	Identifier id;
	Date createdAt;
	
	public Entity() {
		this.id = new Identifier();
		this.createdAt = new Date();
	}

}
