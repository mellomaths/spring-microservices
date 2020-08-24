package com.spring.microservices.photoapp.api.account.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
public class AccountsController {
	
	@GetMapping("health")
	public String healthCheck() {
		return "Working!";
	}

}
