package com.spring.microservices.photoapp.api.users.infrastracture.service.encrypter.bcrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.microservices.photoapp.api.users.domain.users.UserPasswordEncoder;

@Component
@Primary
public class UserPasswordEncoderBCryptImpl implements UserPasswordEncoder {
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserPasswordEncoderBCryptImpl(final BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public String encode(String password) {
		return bCryptPasswordEncoder.encode(password);
	}

}
