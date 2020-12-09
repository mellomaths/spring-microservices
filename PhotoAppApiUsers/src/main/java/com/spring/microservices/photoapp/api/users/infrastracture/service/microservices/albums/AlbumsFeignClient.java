package com.spring.microservices.photoapp.api.users.infrastracture.service.microservices.albums;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.microservices.photoapp.api.users.domain.albums.AlbumDto;
import com.spring.microservices.photoapp.api.users.domain.albums.AlbumsClient;

@Component
@FeignClient(name="albums-ms")
public interface AlbumsFeignClient extends AlbumsClient {

	@Override
	@GetMapping("/users/{id}/albums")
	public List<AlbumDto> getAlbumsByUserId(@PathVariable("id") String userId);
}
