package com.apirest.webflux.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.webflux.document.Playlist;
import com.apirest.webflux.dto.request.PlaylistRequestDto;
import com.apirest.webflux.dto.response.PlaylistResponseDto;
import com.apirest.webflux.repository.PlaylistRepository;
import com.apirest.webflux.service.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	@Autowired
	private PlaylistRepository playlistRepository;

	@Override
	public Flux<PlaylistResponseDto> findAll() {
		return playlistRepository.findAll()
			.map(playlist -> playlist.toRepresentationModel());
	}

	@Override
	public Mono<PlaylistResponseDto> findById(String id) {
		return playlistRepository.findById(id).map(playlist -> playlist.toRepresentationModel());
	}

	@Override
	public Mono<PlaylistResponseDto> save(PlaylistRequestDto playlistData) {
		Playlist playlist = new Playlist(playlistData.getName());
		return playlistRepository.save(playlist).map(playlistSaved -> playlist.toRepresentationModel());
	}

	
}
