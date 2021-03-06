package com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo.users;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoUsersRepository extends MongoRepository<UserDocument, String> {

	@Query("{ 'email' : ?0 }")
	List<UserDocument> findByEmail(String email);
	
}
