package com.spring.microservices.photoapp.api.users.domain;

import com.spring.microservices.photoapp.api.users.domain.valueobjects.Identifier;
import com.spring.microservices.photoapp.api.users.shared.UserDto;

public class User implements Entity {

	private final String firstName;
	private final String lastName;
	private final String email;
	private final String password;
	private String encryptedPassword;
	
	public User(String fistName, String lastName, String email, String password) {
		this.firstName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.encryptedPassword = null;
	}
	
	public static User of(UserDto userData) {
		User user = new User(
				userData.getFirstName(), 
				userData.getLastName(), 
				userData.getEmail(),
				userData.getPassword());
		return user;
	}
	
	public UserDto toDto() {
		UserDto dto = new UserDto();
		dto.setId(id.toString());
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setEncryptedPassword(encryptedPassword);
		return dto;
	}

	public Identifier getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

}
