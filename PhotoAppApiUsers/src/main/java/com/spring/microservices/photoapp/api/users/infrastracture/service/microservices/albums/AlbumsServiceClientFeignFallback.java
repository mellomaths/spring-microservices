package com.spring.microservices.photoapp.api.users.infrastracture.service.microservices.albums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.microservices.photoapp.api.users.domain.albums.AlbumDto;

@Component
public class AlbumsServiceClientFeignFallback implements AlbumsServiceFeignClient {

	public List<AlbumDto> getAlbumsByUserId(String userId) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}


}
