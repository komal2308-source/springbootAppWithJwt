# Spring Boot JWT Demo (with Docker)

A minimal Spring Boot 3 + Spring Security demo that issues and validates JWTs.

## Build & Run (Maven)
```bash
mvn clean package -DskipTests
java -jar target/jwtdemo-1.0.0.jar
```

## Build & Run (Docker)
```bash
docker build -t spring-boot-jwt-demo .
docker run -p 8080:8080 spring-boot-jwt-demo
```

## Test
### Get Token
```bash
curl -X POST "http://localhost:8080/auth/login?username=admin&password=password"
```

### Call Secured API
```bash
curl -H "Authorization: Bearer <TOKEN>" http://localhost:8080/auth/secure
```
