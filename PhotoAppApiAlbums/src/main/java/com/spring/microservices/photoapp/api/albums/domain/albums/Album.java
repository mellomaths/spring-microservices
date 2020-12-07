package com.spring.microservices.photoapp.api.albums.domain.albums;

import com.spring.microservices.photoapp.api.albums.domain.Entity;

public class Album extends Entity {

	private final String userId;
	private final String name;
	private final String description;
	
	public Album(String userId, String name, String description) {
		super();
		this.userId = userId;
		this.name = name;
		this.description = description;
	}
	
	public static Album of(AlbumDto albumData) {
		Album album = new Album(
				albumData.getUserId(),
				albumData.getName(),
				albumData.getDescription());
		return album;
	}
	
	public AlbumDto toDto() {
		AlbumDto dto = new AlbumDto();
		dto.setId(id.toString());
		dto.setUserId(userId);
		dto.setName(name);
		dto.setDescription(description);
		dto.setCreatedAt(createdAt.toString());
		return dto;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
}
