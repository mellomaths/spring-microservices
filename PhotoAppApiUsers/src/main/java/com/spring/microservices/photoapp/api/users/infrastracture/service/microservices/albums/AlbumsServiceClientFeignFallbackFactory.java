package com.spring.microservices.photoapp.api.users.infrastracture.service.microservices.albums;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class AlbumsServiceClientFeignFallbackFactory implements FallbackFactory<AlbumsServiceFeignClient> {

	@Override
	public AlbumsServiceFeignClient create(Throwable cause) {
		// TODO Auto-generated method stub
		return new AlbumsServiceClientFeignFallback(cause);
	}

}

