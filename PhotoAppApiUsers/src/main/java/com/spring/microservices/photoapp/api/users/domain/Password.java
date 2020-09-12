package com.spring.microservices.photoapp.api.users.domain;

import java.io.Serializable;

import com.spring.microservices.photoapp.api.users.domain.users.UsersPasswordEncoder;

public class Password implements Serializable {

	private static final long serialVersionUID = 400083506522856255L;
	
	private String original;
	private String encrypted;
	
	public Password(String value) {
		this.original = value;
		this.encrypted = null;
	}
	
	public void encrypt(UsersPasswordEncoder passwordEncoder) {
		encrypted = passwordEncoder.encode(original);
	}

	public String getOriginal() {
		return original;
	}

	public String getEncrypted() {
		return encrypted;
	}
	
}
