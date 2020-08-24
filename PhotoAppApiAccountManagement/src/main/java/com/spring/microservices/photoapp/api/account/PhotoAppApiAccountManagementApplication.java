package com.spring.microservices.photoapp.api.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PhotoAppApiAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiAccountManagementApplication.class, args);
	}

}
