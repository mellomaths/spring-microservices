package com.apirest.webflux.document;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.apirest.webflux.dto.response.PlaylistResponseDto;

@Document
public class Playlist {
	
	@Id
	private String id;
	private String name;
	
	public Playlist(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public PlaylistResponseDto toRepresentationModel() {
		return new PlaylistResponseDto(id, name);
	}

}
