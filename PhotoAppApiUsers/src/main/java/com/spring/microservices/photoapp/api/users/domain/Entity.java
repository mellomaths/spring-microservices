package com.spring.microservices.photoapp.api.users.domain;

import com.spring.microservices.photoapp.api.users.domain.valueobjects.Date;
import com.spring.microservices.photoapp.api.users.domain.valueobjects.Identifier;

public class Entity {
	
	protected Identifier id;
	protected Date createdAt;
	
	public Entity() {
		this.id = new Identifier();
		this.createdAt = new Date();
	}
	
	public Identifier getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	
}
