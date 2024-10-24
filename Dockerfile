FROM openjdk:17
MAINTAINER nttdata

ARG JAR_FILE=*.jar
COPY api/target/api-1.0.0-SNAPSHOT.jar application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]

