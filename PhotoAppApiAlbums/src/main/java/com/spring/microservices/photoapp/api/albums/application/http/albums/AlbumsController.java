package com.spring.microservices.photoapp.api.albums.application.http.albums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.photoapp.api.albums.domain.albums.AlbumDto;
import com.spring.microservices.photoapp.api.albums.domain.albums.AlbumsService;

@RestController
@RequestMapping("/users/{id}/albums")
public class AlbumsController {

	@Autowired
	private AlbumsService albumsService;
	
	@GetMapping
	public List<AlbumResponseBody> getAlbumsByUserId(@PathVariable String id) {
		List<AlbumDto> albums = albumsService.getAlbumsByUserId(id);
		if (albums == null || albums.isEmpty()) {
			return new ArrayList<>();
		}
		
		ArrayList<AlbumResponseBody> result = new ArrayList<AlbumResponseBody>();
		albums.forEach(album -> result.add(AlbumResponseBody.of(album)));
		return result;
	}
}
