package com.spring.microservices.photoapp.api.users.application.http.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.spring.microservices.photoapp.api.users.application.http.ErrorResponseBody;
import com.spring.microservices.photoapp.api.users.application.http.exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceNotFoundExceptionHandler {
	
	@ExceptionHandler(value = {ResourceNotFoundException.class})
	protected ResponseEntity<ErrorResponseBody> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String path = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
		ErrorResponseBody errorResponse = new ErrorResponseBody(new Date(), status, ex.getMessage(), path); 
		return new ResponseEntity<ErrorResponseBody>(errorResponse, status);
	}
	
	
}
