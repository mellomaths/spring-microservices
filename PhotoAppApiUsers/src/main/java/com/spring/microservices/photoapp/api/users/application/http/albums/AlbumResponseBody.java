package com.spring.microservices.photoapp.api.users.application.http.albums;

import com.spring.microservices.photoapp.api.users.domain.albums.AlbumDto;

public class AlbumResponseBody {
	
	private String id;
	private String userId;
	private String name;
	private String description;
	private String createdAt;
	
	public AlbumResponseBody(String id, String userId, String name, String description, String createdAt) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
	}
	
	public static AlbumResponseBody of(AlbumDto dto) {
		return new AlbumResponseBody(dto.getId(), dto.getUserId(), dto.getName(), dto.getDescription(), dto.getCreatedAt());
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
