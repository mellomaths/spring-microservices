package com.spring.microservices.photoapp.api.users.infrastracture.service.microservices.albums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.spring.microservices.photoapp.api.users.domain.albums.AlbumDto;
import com.spring.microservices.photoapp.api.users.domain.albums.AlbumsClient;

@Component
@Primary
public class AlbumsClientImpl implements AlbumsClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;

	@Override
	public List<AlbumDto> getAlbumsByUserId(String userId) {
		String url = String.format(env.getRequiredProperty("get-albums-by-user-id.url"), userId);
		ResponseEntity<List<AlbumsServiceResponseBody>> serviceResponse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumsServiceResponseBody>>() {
		});
		List<AlbumsServiceResponseBody> albums = serviceResponse.getBody();
		List<AlbumDto> result = new ArrayList<>();
		albums.forEach(album -> result.add(album.toDto()));
		return result;
	}

}
