FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/docker-cities-0.0.1-SNAPSHOT.jar message-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/cities-0.0.1-SNAPSHOT.jar"]
