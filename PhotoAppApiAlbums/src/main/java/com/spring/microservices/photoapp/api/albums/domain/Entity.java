package com.spring.microservices.photoapp.api.albums.domain;


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
