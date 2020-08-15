package com.apirest.webflux.dto.request;

public class PlaylistRequestDto {
	
	private String name;
	
	public PlaylistRequestDto(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
