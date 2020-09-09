package com.spring.microservices.photoapp.api.users.infrastracture.configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.spring.microservices.photoapp.api.users.infrastracture.repository.mongo.SpringDataMongoUserRepository;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoUserRepository.class)
public class MongoConfiguration {

}
