package com.appsdeveloperblog.app.ws.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.appsdeveloperblog.app.ws.exception.ResourceNotFoundException;
import com.appsdeveloperblog.app.ws.ui.model.response.ErrorResponse;

@ControllerAdvice
public class ResourceNotFoundExceptionHandler {
	
	@ExceptionHandler(value = {ResourceNotFoundException.class})
	protected ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String path = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
		ErrorResponse errorResponse = new ErrorResponse(new Date(), status, ex.getMessage(), path); 
		return new ResponseEntity<ErrorResponse>(errorResponse, status);
	}
	
	
}
