package com.spring.microservices.photoapp.api.albums.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Date implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String value;
	
	public Date() {
		LocalDateTime datetime = LocalDateTime.now();
		value = datetime.toString();
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}