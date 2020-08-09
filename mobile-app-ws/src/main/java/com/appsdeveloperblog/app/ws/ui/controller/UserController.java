package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public String getUsers(@RequestParam(value = "page", defaultValue="1") int page, 
			@RequestParam(value = "limit", defaultValue = "100") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "GET /users was called! Page = " + page + " and Limit = " + limit;
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public String createUser() {
		return "POST /users was called!";
	}
	
	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserRest getUserById(@PathVariable String userId) {
		UserRest returnValue = new UserRest(userId, "Matheus", "Mello de Lima", "mellomatheuslima@gmail.com");
		return returnValue;
	}
	
	@PutMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public String updateUser(@PathVariable String userId) {
		return "PUT /users/" + userId + "  was called!";
	}
	
	@DeleteMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public String deleteUser(@PathVariable String userId) {
		return "DELETE /users/" + userId + "  was called!";
	}
	
}
