package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateUserRequest {
	
	@NotNull(message = "Field 'firstName' is mandatory.")
	@NotBlank(message = "Field 'firstName' cannot be blank.")
	private String firstName;
	
	@NotNull(message = "Field 'lastName' is mandatory.")
	@NotBlank(message = "Field 'lastName' cannot be blank.")
	private String lastName;
	
	public UpdateUserRequest(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

}
