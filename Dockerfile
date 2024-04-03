FROM maven:3.9 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM adoptopenjdk/openjdk11
WORKDIR /app
COPY --from=builder app/target/study-buddy-0.0.1.jar study-buddy-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "study-buddy-0.0.1.jar"]
