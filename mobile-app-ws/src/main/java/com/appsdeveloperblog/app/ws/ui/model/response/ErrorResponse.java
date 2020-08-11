package com.appsdeveloperblog.app.ws.ui.model.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	private Date timestamp;
	private int status;
	private String description;
	private String message;
	private String path;
	private List<String> details = new ArrayList<String>();
	
	public ErrorResponse(Date timestamp, HttpStatus statusCode, String message, String path) {
		this.timestamp = timestamp;
		this.status = statusCode.value();
		this.description = statusCode.name();
		this.message = message;
		this.path = path;
	}
	
	public ErrorResponse(Date timestamp, HttpStatus statusCode, String message, String path, List<String> details) {
		this.timestamp = timestamp;
		this.status = statusCode.value();
		this.description = statusCode.name();
		this.message = message;
		this.path = path;
		this.details = details;
	}

	public void addErrorDetail(String errorDetail) {
		this.details.add(errorDetail);
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public List<String> getDetails() {
		return details;
	}
	
	public void setDetails(List<String> details) {
		this.details = details;
	}
	
}
