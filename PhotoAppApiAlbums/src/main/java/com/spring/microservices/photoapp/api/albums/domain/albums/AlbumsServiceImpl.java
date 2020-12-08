package com.spring.microservices.photoapp.api.albums.domain.albums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AlbumsServiceImpl implements AlbumsService {

	@Override
	public List<AlbumDto> getAlbumsByUserId(String userId) {
		List<Album> albums = new ArrayList<Album>();
		
		albums.add(new Album(userId, "My Beautiful Dark Twisted Fantasy", "My Beautiful Dark Twisted Fantasy is the fifth studio album by American rapper and producer Kanye West. It was released on November 22, 2010, by Def Jam Recordings and Roc-A-Fella Records."));
		albums.add(new Album(userId, "To Pimp a Butterfly", "To Pimp a Butterfly is the third studio album by American rapper Kendrick Lamar. It was released on March 15, 2015, by Top Dawg Entertainment, Aftermath Entertainment and Interscope Records."));
		
		ArrayList<AlbumDto> result = new ArrayList<AlbumDto>();
		albums.forEach(album -> result.add(album.toDto())); 
		return result;
	}

}
