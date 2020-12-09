package com.spring.microservices.photoapp.api.users.infrastracture.service.microservices.albums;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.microservices.photoapp.api.users.domain.albums.AlbumDto;

import feign.FeignException;

public class AlbumsServiceClientFeignFallback implements AlbumsServiceFeignClient {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private final Throwable cause;
	
	public AlbumsServiceClientFeignFallback(Throwable cause) {
		this.cause = cause;
	}

	public List<AlbumDto> getAlbumsByUserId(String userId) {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			logger.error("404 error took place when getAlbumsByUserId was called with userId=" + userId + ". Error message: " + cause.getLocalizedMessage());
		} else {
			logger.error("Other error took place. Error message: " + cause.getLocalizedMessage());
		}
		
		return new ArrayList<>();
	}


}
