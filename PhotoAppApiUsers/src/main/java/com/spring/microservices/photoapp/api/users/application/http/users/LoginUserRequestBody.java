package com.spring.microservices.photoapp.api.users.application.http.users;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.spring.microservices.photoapp.api.users.domain.users.UserDto;

public class LoginUserRequestBody {
	
	@NotNull(message="Field 'email' cannot be null.")
	@Email
	private String email;
	
	@NotNull(message="Field 'password' cannot be null.")
	private String password;
	
	public UserDto toDto() {
		UserDto dto = new UserDto();
		dto.setEmail(email);
		dto.setPassword(password);
		return dto;
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
