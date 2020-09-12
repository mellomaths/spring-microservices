package com.spring.microservices.photoapp.api.users.application.http.users;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.spring.microservices.photoapp.api.users.shared.UserDto;

public class CreateUserRequestBody {

	@NotNull(message="Field 'firstName' cannot be null.")
	private String firstName;
	
	@NotNull(message="Field 'lastName' cannot be null.")
	private String lastName;
	
	@NotNull(message="Field 'email' cannot be null.")
	@Email
	private String email;
	
	@NotNull(message="Field 'password' cannot be null.")
	@Size(min=8, max=16, message="Password must be equal or greater than 8 characters and less than 16 characters.")
	private String password;
	
	public UserDto toDto() {
		UserDto dto = new UserDto();
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmail(email);
		dto.setPassword(password);
		return dto;
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
