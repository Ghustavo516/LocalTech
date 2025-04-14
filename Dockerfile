FROM maven:3.9-openjdk-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean install -U

FROM openjdk:21-alpine
WORKDIR /app
COPY --from=builder /app/target/app.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "localtech.jar"]