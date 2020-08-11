package com.appsdeveloperblog.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.request.UpdateUserRequest;
import com.appsdeveloperblog.app.ws.ui.model.request.UserRequest;
import com.appsdeveloperblog.app.ws.ui.model.response.UserResponse;

@RestController
@RequestMapping("users")
public class UserController {
	
	Map<String, UserResponse> users;
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> getUsers(@RequestParam(value = "page", defaultValue="1") int page, 
			@RequestParam(value = "limit", defaultValue = "100") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		
		String message = "GET /users was called! Page = " + page + " and Limit = " + limit; 
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userData) {
		String userId = UUID.randomUUID().toString();
		UserResponse returnValue = new UserResponse(userId, "Matheus", "Mello de Lima", "mellomatheuslima@gmail.com");
		if (users == null) {
			users = new HashMap<>();  
		}
		 
		users.put(userId, returnValue);
		return new ResponseEntity<UserResponse>(returnValue, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserResponse> getUserById(@PathVariable String userId) {
		if (users == null || !users.containsKey(userId)) {
			return new ResponseEntity<UserResponse>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserResponse>(users.get(userId), HttpStatus.OK);
	}
	
	@PutMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserResponse> updateUserById(@PathVariable String userId, @Valid @RequestBody UpdateUserRequest updateUserData) {
		if (users == null || !users.containsKey(userId)) {
			return new ResponseEntity<UserResponse>(HttpStatus.NOT_FOUND);
		}
		
		UserResponse storedUser = users.get(userId);
		storedUser.setFirstName(updateUserData.getFirstName());
		storedUser.setLastName(updateUserData.getLastName());
		users.put(userId, storedUser);
		
		return new ResponseEntity<UserResponse>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> deleteUserById(@PathVariable String userId) {
		String message = "DELETE /users/" + userId + "  was called!";
		return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
	}
	
}
