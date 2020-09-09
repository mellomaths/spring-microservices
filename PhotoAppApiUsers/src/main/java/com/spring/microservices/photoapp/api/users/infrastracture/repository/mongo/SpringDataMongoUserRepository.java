package com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo.document.UserDocument;

@Repository
public interface SpringDataMongoUserRepository extends MongoRepository<UserDocument, String> {

}
