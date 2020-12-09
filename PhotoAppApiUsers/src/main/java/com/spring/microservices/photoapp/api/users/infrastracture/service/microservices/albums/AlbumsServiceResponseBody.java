package com.spring.microservices.photoapp.api.users.infrastracture.service.microservices.albums;

import com.spring.microservices.photoapp.api.users.domain.albums.AlbumDto;

public class AlbumsServiceResponseBody {
	private String id;
	private String userId;
	private String name;
	private String description;
	private String createdAt;
	
	public AlbumsServiceResponseBody(String id, String userId, String name, String description, String createdAt) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
	}
	
	public AlbumDto toDto() {
		AlbumDto dto = new AlbumDto();
		dto.setId(id);
		dto.setUserId(userId);
		dto.setName(name);
		dto.setDescription(description);
		dto.setCreatedAt(createdAt);
		return dto;
	}

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
