package com.spring.microservices.photoapp.api.users.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {
	
	@Autowired
	private Environment env;
	
	@GetMapping("health")
	public String healthCheck() {
		return "Working on port " + env.getProperty("local.server.port");
	}
	
}
