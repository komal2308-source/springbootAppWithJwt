# Step 1: Build stage (Maven)
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy pom.xml and download dependencies (layer caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and build
COPY src ./src
RUN mvn package -DskipTests

# Step 2: Runtime stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy jar from builder
COPY --from=builder /app/target/jwtdemo-1.0.0.jar app.jar

# Expose port
EXPOSE 8080

# Run app
ENTRYPOINT ["java","-jar","/app/app.jar"]
