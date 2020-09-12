package com.spring.microservices.photoapp.api.users.application.http.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource was not found.")
public class ResourceNotFoundException  extends RuntimeException {

	private static final long serialVersionUID = 6586141886625618072L;
	
    public ResourceNotFoundException() {
        super();
    }
    
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
	
}
