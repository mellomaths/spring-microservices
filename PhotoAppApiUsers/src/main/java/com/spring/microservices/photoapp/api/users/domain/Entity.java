package com.spring.microservices.photoapp.api.users.domain;

import com.spring.microservices.photoapp.api.users.domain.valueobjects.Identifier;

public interface Entity {
	
	Identifier id = new Identifier();

}
