package com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo.users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoUsersRepository extends MongoRepository<UserDocument, String> {

}
