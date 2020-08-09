package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.response.UserResponse;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> getUsers(@RequestParam(value = "page", defaultValue="1") int page, 
			@RequestParam(value = "limit", defaultValue = "100") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		
		String message = "GET /users was called! Page = " + page + " and Limit = " + limit; 
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> createUser() {
		String message = "POST /users was called!";
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserResponse> getUserById(@PathVariable String userId) {
		UserResponse returnValue = new UserResponse(userId, "Matheus", "Mello de Lima", "mellomatheuslima@gmail.com");
		return new ResponseEntity<UserResponse>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> updateUser(@PathVariable String userId) {
		String message = "PUT /users/" + userId + "  was called!";
		return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
		String message = "DELETE /users/" + userId + "  was called!";
		return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
	}
	
}
