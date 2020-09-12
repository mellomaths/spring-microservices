package com.spring.microservices.photoapp.api.users.infrastracture.service.authentication.springsecurity;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import com.spring.microservices.photoapp.api.users.domain.users.UsersTokenGenerator;

@Component
@Primary
public class TokenGeneratorSpringSecurityImpl implements UsersTokenGenerator {

	@Override
	public String generate(String email, String password) {
		return new UsernamePasswordAuthenticationToken(email, password, new ArrayList<>()).toString();
	}

}
