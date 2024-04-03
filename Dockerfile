FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY ./src ./src
RUN mvn clean install -Dmaven.test.skip=true

FROM amazoncorretto:21-alpine3.19
WORKDIR /app
VOLUME /redis-service
COPY --from=builder app/target/study-buddy-0.0.1.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
