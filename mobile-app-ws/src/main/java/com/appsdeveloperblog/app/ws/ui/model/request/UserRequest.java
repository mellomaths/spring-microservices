package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {
	
	@NotNull(message = "Field 'firstName' is mandatory.")
	@NotBlank(message = "Field 'firstName' cannot be blank.")
	private String firstName;
	
	@NotNull(message = "Field 'lastName' is mandatory.")
	@NotBlank(message = "Field 'lastName' cannot be blank.")
	private String lastName;
	
	@NotNull(message = "Field 'email' is mandatory.")
	@NotBlank(message = "Field 'email' cannot be blank.") 
	@Email(message = "Field 'email' should respect an email format.")
	private String email;
	
	@NotNull(message = "Field 'password' is mandatory.")
	@NotBlank(message = "Field 'password' cannot be blank.")
	@Size(min=8, message = "Field 'password' should have at least 8 characters.")
	private String password;
	
	public UserRequest(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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
	
	public void setRequest(String password) {
		this.password = password;
	}

}
