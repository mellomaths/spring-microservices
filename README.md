# spring-microservices

## Running spring application passing instance_id

```
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.application.instance_id=mellomaths
```

## Running spring application passing port

```
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.application.instance_id=mellomaths2,--server.port=8999
```

## Responsabilities

### Users Microservice

- Create user (Sign-up)

- User Login (Sign-in or Authentication)

- Get user details

- Update user

- Delete user

## Spring Boot Actuator

Spring Boot includes a number of additional features to help you monitor and manage your application when you push it to production. You can choose to manage and monitor your application by using HTTP endpoints or with JMX. Auditing, health, and metrics gathering can also be automatically applied to your application.

### Features

Actuator endpoints let you monitor and interact with your application. Spring Boot includes a number of built-in endpoints and lets you add your own. For example we have:

- **/health**: Health check, provides basic application health information.
- **/beans**: Displays a complete list of beans in your Microservice.
- **/httptrace**: Displays HTTP trace information (by default, the last 100 HTTP request-response exchanges).
- **References**: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready