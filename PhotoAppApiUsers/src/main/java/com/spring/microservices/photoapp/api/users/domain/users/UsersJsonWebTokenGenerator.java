package com.spring.microservices.photoapp.api.users.domain.users;

import java.util.Date;

public interface UsersJsonWebTokenGenerator {
	
	String generateJwtBasedOnHS512Algorithm(String userId, Date expiration, String base64EncodedSecretKey);

}
