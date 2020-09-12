package com.spring.microservices.photoapp.api.users.application.http.exception.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.microservices.photoapp.api.users.application.http.ErrorResponseBody;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, 
		HttpHeaders headers, HttpStatus status, WebRequest request) {
		
        List<String> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        
        String path = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
    
        ErrorResponseBody errorResponse = new ErrorResponseBody(new Date(), status, "Please check your request body.", path, details); 

        return new ResponseEntity<>(errorResponse, headers, status);
	}
	
}
