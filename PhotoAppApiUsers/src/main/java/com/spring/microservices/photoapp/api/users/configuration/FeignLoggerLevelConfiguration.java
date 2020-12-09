package com.spring.microservices.photoapp.api.users.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignLoggerLevelConfiguration {
	
	@Bean
	public Logger.Level getFeignLoggerLeve() {
		return Logger.Level.BASIC;
	}

}
