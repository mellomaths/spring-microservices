package com.spring.microservices.photoapp.api.users.application.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.photoapp.api.users.application.request.CreateUserRequest;
import com.spring.microservices.photoapp.api.users.application.response.UserResponse;
import com.spring.microservices.photoapp.api.users.domain.exception.UserNotFoundException;
import com.spring.microservices.photoapp.api.users.domain.service.UsersService;
import com.spring.microservices.photoapp.api.users.shared.UserDto;

@RestController
@RequestMapping("users")
public class UsersController { 
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UsersService userService;
	
	@GetMapping("health")
	public String healthCheck() {
		return "Working on port " + env.getProperty("local.server.port");
	}
	
	@PostMapping
	public String createUser(@Valid @RequestBody CreateUserRequest userData) {
		String userId = userService.createUser(userData.toDto());
		return "createUser() method was called! User " + userId + " created!";
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
		try {
			UserDto user = userService.getUserById(id);
			return ResponseEntity.ok(UserResponse.of(user));
		} catch (UserNotFoundException err) {
			return (ResponseEntity<UserResponse>) ResponseEntity.notFound();
		}
	}
	
}
