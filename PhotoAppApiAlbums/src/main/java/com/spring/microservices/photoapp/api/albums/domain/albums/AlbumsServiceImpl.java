package com.spring.microservices.photoapp.api.albums.domain.albums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AlbumsServiceImpl implements AlbumsService {

	@Override
	public List<AlbumDto> getAlbumsByUserId(String userId) {
		List<Album> albums = new ArrayList<Album>();
		
		albums.add(new Album(userId, "My Beautiful Dark Twisted Fantasy", "My Beautiful Dark Twisted Fantasy é o quinto álbum de estúdio pelo rapper, cantor e compositor de hip hop americano Kanye West. Foi primeiramente lançado em 22 de Novembro de 2010 pela editora discográfica Roc-A-Fella Records."));
		albums.add(new Album(userId, "To Pimp a Butterfly", "To Pimp a Butterfly é o terceiro álbum de estúdio do rapper estadunidense Kendrick Lamar. O álbum foi lançado em 16 de março de 2015, pelas editoras discográficas Top Dawg Entertainment, Aftermath Entertainment, e distribuído pela Interscope Records"));
		
		ArrayList<AlbumDto> result = new ArrayList<AlbumDto>();
		albums.forEach(album -> result.add(album.toDto())); 
		return result;
	}

}
