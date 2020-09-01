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
