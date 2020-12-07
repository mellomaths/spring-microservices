package com.spring.microservices.photoapp.api.albums.domain.albums;

import java.io.Serializable;

public class AlbumDto implements Serializable {

	private static final long serialVersionUID = -3018918741899096115L;
	
	private String id;
	private String userId;
	private String name;
	private String description;
	private String createdAt;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
}
