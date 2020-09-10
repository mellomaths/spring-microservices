package com.spring.microservices.photoapp.api.users.application.response;

import com.spring.microservices.photoapp.api.users.shared.UserDto;

public class UserResponse {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String createdAt;

	public UserResponse(String id, String firstName, String lastName, String email, String createdAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createdAt = createdAt;
	}

	public static UserResponse of(UserDto dto) {
		return new UserResponse(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getCreatedAt());
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

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
