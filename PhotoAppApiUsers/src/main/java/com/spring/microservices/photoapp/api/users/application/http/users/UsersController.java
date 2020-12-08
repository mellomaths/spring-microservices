package com.spring.microservices.photoapp.api.users.application.http.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.photoapp.api.users.application.http.albums.AlbumResponseBody;
import com.spring.microservices.photoapp.api.users.application.http.exception.ResourceNotFoundException;
import com.spring.microservices.photoapp.api.users.domain.albums.AlbumDto;
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
	public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestBody userData) {
		String userId = userService.createUser(userData.toDto());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Entity", userId);
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserResponseBody> getUserById(@PathVariable String id, @RequestParam(name="expand", required=false) String expand) throws ResourceNotFoundException {
		try {
			UserDto user = userService.getUserById(id);
			UserResponseBody responseBody = UserResponseBody.of(user);
			if (expand != null && expand.toLowerCase().contains("albums")) {
				List<AlbumDto> albums = userService.getAlbumsByUserId(id);
				List<AlbumResponseBody> albumsResponseBody = new ArrayList<>();
				albums.forEach(album -> albumsResponseBody.add(AlbumResponseBody.of(album)));
				responseBody.setAlbums(albumsResponseBody);
			}
			return ResponseEntity.ok(responseBody);
		} catch (UserNotFoundException err) {
			throw new ResourceNotFoundException(err.getMessage());
		}
	}
	
}
