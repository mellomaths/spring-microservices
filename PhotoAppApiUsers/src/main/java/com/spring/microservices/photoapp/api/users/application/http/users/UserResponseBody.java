package com.spring.microservices.photoapp.api.users.application.http.users;

import java.util.ArrayList;
import java.util.List;

import com.spring.microservices.photoapp.api.users.application.http.albums.AlbumResponseBody;
import com.spring.microservices.photoapp.api.users.domain.users.UserDto;

public class UserResponseBody {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private List<AlbumResponseBody> albums;
	private String createdAt;

	public UserResponseBody(String id, String firstName, String lastName, String email, String createdAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.albums = new ArrayList<>();
		this.createdAt = createdAt;
	}
	
	public UserResponseBody(String id, String firstName, String lastName, String email, List<AlbumResponseBody> albums, String createdAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.albums = albums;
		this.createdAt = createdAt;
	}

	public static UserResponseBody of(UserDto dto) {
		return new UserResponseBody(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getCreatedAt());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedAt() {
		return createdAt;
	}
	
	public List<AlbumResponseBody> getAlbums() {
		return albums;
	}

	public void setAlbums(List<AlbumResponseBody> albums) {
		this.albums = albums;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}	

}
