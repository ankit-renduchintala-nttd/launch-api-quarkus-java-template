FROM mcr.microsoft.com/devcontainers/java:1-17-bookworm
# MAINTAINER nttdata
WORKDIR /app
RUN apt-get update && apt-get install -y curl git vim maven build-essential
ADD api/target/api-1.0.0-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]

