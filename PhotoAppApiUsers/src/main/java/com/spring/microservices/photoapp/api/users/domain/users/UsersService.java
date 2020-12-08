package com.spring.microservices.photoapp.api.users.domain.users;

import java.util.List;

import com.spring.microservices.photoapp.api.users.domain.albums.AlbumDto;
import com.spring.microservices.photoapp.api.users.domain.users.exception.UserNotFoundException;

public interface UsersService {

	String createUser(UserDto userData);
	
	UserDto getUserById(String id) throws UserNotFoundException;
	
	UserDto getUserByEmail(String email) throws UserNotFoundException;
	
	List<AlbumDto> getAlbumsByUserId(String userId); 

}
