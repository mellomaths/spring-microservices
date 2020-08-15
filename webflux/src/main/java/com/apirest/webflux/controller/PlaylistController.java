package com.apirest.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.dto.request.PlaylistRequestDto;
import com.apirest.webflux.dto.response.PlaylistResponseDto;
import com.apirest.webflux.service.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("playlists")
public class PlaylistController {
	
	@Autowired
	private PlaylistService playlistService;
	
	@GetMapping
	public Flux<PlaylistResponseDto> getAllPlaylists() {
		return playlistService.findAll();
	}
	
	@GetMapping(path = "/{playlistId}")
	public Mono<PlaylistResponseDto> getPlaylistById(@PathVariable String playlistId) {
		return playlistService.findById(playlistId);
	}
	
	@PostMapping
	public Mono<PlaylistResponseDto> postPlaylist(@RequestBody PlaylistRequestDto playlistData) {
		return playlistService.save(playlistData);		
	}
	
}
