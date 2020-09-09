package com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo.document.UserDocument;

public interface UserRepository extends MongoRepository<UserDocument, String> {

}
