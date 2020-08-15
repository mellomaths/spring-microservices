package com.apirest.webflux.dto.response;

public class PlaylistResponseDto {
	
	private final String id;
	private final String name;
	
	public PlaylistResponseDto(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

}
