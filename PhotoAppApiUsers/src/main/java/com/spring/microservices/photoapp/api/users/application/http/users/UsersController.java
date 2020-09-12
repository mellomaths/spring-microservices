package com.spring.microservices.photoapp.api.users.application.http.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.photoapp.api.users.application.http.exception.ResourceNotFoundException;
import com.spring.microservices.photoapp.api.users.domain.users.UserDto;
import com.spring.microservices.photoapp.api.users.domain.users.UsersService;
import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

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
	public String createUser(@RequestBody CreateUserRequestBody userData) {
		String userId = userService.createUser(userData.toDto());
		return "createUser() method was called! User " + userId + " created!";
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserResponseBody> getUserById(@PathVariable String id) throws ResourceNotFoundException {
		try {
			UserDto user = userService.getUserById(id);
			return ResponseEntity.ok(UserResponseBody.of(user));
		} catch (UserNotFoundException err) {
			throw new ResourceNotFoundException(err.getMessage());
		}
	}
	
}
