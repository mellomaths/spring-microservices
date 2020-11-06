package com.spring.microservices.photoapp.api.users.infrastracture.service.authentication.springsecurity;

import java.util.Date;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.microservices.photoapp.api.users.domain.users.UsersJsonWebTokenGenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
@Primary
public class JsonWebTokenGeneratorImpl implements UsersJsonWebTokenGenerator {

	@Override
	public String generateJwtBasedOnHS512Algorithm(String userId, Date expiration, String base64EncodedSecretKey) {
		String token = Jwts.builder()
				.setSubject(userId)
				.setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS512, base64EncodedSecretKey)
				.compact();
		return token;
	}

}
