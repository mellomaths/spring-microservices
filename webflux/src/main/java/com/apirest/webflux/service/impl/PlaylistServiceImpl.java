package com.apirest.webflux.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.apirest.webflux.document.Playlist;
import com.apirest.webflux.repository.PlaylistRepository;
import com.apirest.webflux.service.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlaylistServiceImpl implements PlaylistService {
	
	@Autowired
	private PlaylistRepository playlistRepository;

	@Override
	public Flux<Playlist> findAll() {		
		return playlistRepository.findAll();
	}

	@Override
	public Mono<Playlist> findById(String id) {
		return playlistRepository.findById(id);
	}

	@Override
	public Mono<Playlist> save(Playlist playlistData) {
		return playlistRepository.save(playlistData);
	}

	
}
