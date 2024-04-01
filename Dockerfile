FROM maven:3.8.4-openjdk-17-slim AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -f pom.xml clean package

FROM eclipse-temurin:17-alpine
COPY --from=builder /app/target/study-buddy-0.0.1.jar /app/study-buddy-0.0.1.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "study-buddy-0.0.1.jar"]
