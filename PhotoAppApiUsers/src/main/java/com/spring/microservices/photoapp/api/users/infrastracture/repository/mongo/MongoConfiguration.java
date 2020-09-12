package com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo.users.SpringDataMongoUsersRepository;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoUsersRepository.class)
public class MongoConfiguration {

}
