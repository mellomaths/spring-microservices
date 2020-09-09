package com.spring.microservices.photoapp.api.users.application.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.photoapp.api.users.application.request.CreateUserRequest;
import com.spring.microservices.photoapp.api.users.domain.service.UsersService;

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
	
}
