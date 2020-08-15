package com.apirest.webflux.service;

import com.apirest.webflux.dto.request.PlaylistRequestDto;
import com.apirest.webflux.dto.response.PlaylistResponseDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {
	
	Flux<PlaylistResponseDto> findAll();
	Mono<PlaylistResponseDto> findById(String id);
	Mono<PlaylistResponseDto> save(PlaylistRequestDto playlistData);

}
