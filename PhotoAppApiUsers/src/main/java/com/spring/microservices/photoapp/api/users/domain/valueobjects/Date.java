package com.spring.microservices.photoapp.api.users.domain.valueobjects;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Date implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String value;
	
	public Date() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		value = formatter.format(date);
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}
