package com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.spring.microservices.photoapp.api.users.domain.users.UserDto;

@Document(collection = "user")
public class UserDocument {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String encryptedPassword;
	private String createdAt;
	
	public UserDocument(String id, String firstName, String lastName, String email, String encryptedPassword, String createdAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.createdAt = createdAt;
	}
	
	public static UserDocument of(UserDto userData) {
		UserDocument document = new UserDocument(
				userData.getId(), 
				userData.getFirstName(), 
				userData.getLastName(), 
				userData.getEmail(),
				userData.getEncryptedPassword(),
				userData.getCreatedAt());
		return document;
	}
	
	public UserDto toDto() {
		UserDto dto = new UserDto();
		dto.setId(id.toString());
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		dto.setEncryptedPassword(encryptedPassword);
		dto.setCreatedAt(createdAt);
		return dto;
	}

}