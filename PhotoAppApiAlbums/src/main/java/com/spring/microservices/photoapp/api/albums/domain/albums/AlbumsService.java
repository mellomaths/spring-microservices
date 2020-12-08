package com.spring.microservices.photoapp.api.albums.domain.albums;

import java.util.List;

public interface AlbumsService {
	List<AlbumDto> getAlbumsByUserId(String userId);
}
