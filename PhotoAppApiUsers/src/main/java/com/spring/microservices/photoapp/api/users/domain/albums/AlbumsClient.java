package com.spring.microservices.photoapp.api.users.domain.albums;

import java.util.List;

public interface AlbumsClient {
	
	List<AlbumDto> getAlbumsByUserId(String userId);

}
