package com.apirest.webflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apirest.webflux.document.Playlist;
import com.apirest.webflux.repository.PlaylistRepository;

import reactor.core.publisher.Flux;

@Component
public class DummyData implements CommandLineRunner {
	
	private final PlaylistRepository playlistRepository;
	
	public DummyData(PlaylistRepository playlistRepository) {
		this.playlistRepository = playlistRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		playlistRepository.deleteAll()
			.thenMany(
				Flux.just("API REST Spring Boot", "Deploy a Java application on AWS", "Microservices Development with Spring Cloud")
					.map(name -> new Playlist(name))
					.flatMap(playlistRepository::save)
			).subscribe(System.out::println);
	}

}
