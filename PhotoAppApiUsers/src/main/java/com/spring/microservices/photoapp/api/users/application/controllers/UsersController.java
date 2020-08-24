package com.spring.microservices.photoapp.api.users.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {
	
	@GetMapping("health")
	public String healthCheck() {
		return "Working!";
	}
	
}
