package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue="1") int page, 
			@RequestParam(value = "limit", defaultValue = "100") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "GET /users was called! Page = " + page + " and Limit = " + limit;
	}
	
	@PostMapping
	public String createUser() {
		return "POST /users was called!";
	}
	
	@GetMapping(path = "/{userId}")
	public String getUserById(@PathVariable String userId) {
		return "GET /users/" + userId + "  was called!";
	}
	
	@PutMapping(path = "/{userId}")
	public String updateUser(@PathVariable String userId) {
		return "PUT /users/" + userId + "  was called!";
	}
	
	@DeleteMapping(path = "/{userId}")
	public String deleteUser(@PathVariable String userId) {
		return "DELETE /users/" + userId + "  was called!";
	}
	
}
