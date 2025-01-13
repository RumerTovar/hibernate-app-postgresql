FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/posgredbapp-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} posgredbapp.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "posgredbapp.jar"]
