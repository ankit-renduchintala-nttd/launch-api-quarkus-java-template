# Quarkus OpenAPI, Hexagonal & CQRS Template

## Table of Contents
1. [Introduction](#1-introduction)
2. [Requirements](#2-requirements)
3. [Building the Application](#3-building-the-application)
    1. [Clone the Repository](#31-cloning-the-repository)
    2. [Run Install](#32-run-install)
4. [Run Application](#4-run-application)
    1. [Live Coding with Quarkus](#41-live-coding-with-quarkus)
    2. [Run as Native Executable](#42-run-native-executable)
5. [Miscellaneous](#5-miscellaneous)

## 1. Introduction
This is a template Java/Quarkus project built on the principles of:
- Hexagonal architecture: Clean separation between the core business logic & external interfaces.
- Command Query Responsibility Segregation (CQRS): Separates read & write operations, allowing for better scalability & optimization.
- OpenAPI for API generation: Used for API documentation & generation, providing a standardized way to describe & define RESTful APIs.

<p style="text-align: center;">
  <img alt="Hexagonal pattern" src="https://raw.githubusercontent.com/launchbynttdata/common-platform-documentation/feature/various-pipeline-info/standards/common-development/java/hexagonal/pictures/java.hex.png" width="40%" height="40%"/>
</p>

## 2. Requirements
To compile and run this demo you will need:
- JDK 17+
- Maven
- GraalVM

### Configuring Maven, GraalVM, and JDK 17+
Make sure that the `GRAALVM_HOME`, `JAVA_HOME`, `MAVEN_HOME`, and `M2_HOME` environment variables are set, and that a JDK 17+ `java` and `apache-maven/bin` command is on the path.

See the [Building a Native Executable guide](https://quarkus.io/guides/building-native-image-guide) for help setting up your environment.

## 3. Building the Application

### 3.1. Cloning the Repository
Run the following terminal commands to clone the repo:
```sh
git clone https://github.com/launchbynttdata/launch-quarkus-hex-java-template.git
cd launch-quarkus-hex-java-template
```

### 3.2. Run Install
Run one of the below to install the dependencies and build the application:

> `./mvnw clean install`
> or
> `mvn clean install`

## 4. **Run Application**

### 4.1 Live coding with Quarkus

The Maven Quarkus plugin provides a development mode that supports
live coding. To try this out:

> `./mvnw -f api/pom.xml quarkus:dev`
> or
> `mvn -f api/pom.xml quarkus:dev`

This command will leave Quarkus running in the foreground listening on port 8080.

1. Visit the default endpoint: [http://127.0.0.1:8080](http://127.0.0.1:8080).
    - Make a simple change to [src/main/resources/META-INF/resources/index.html](src/main/resources/META-INF/resources/index.html) file.
    - Refresh the browser to see the updated page.

2. Visit the swagger page here: http://127.0.0.1:8080/swagger-ui

When you're done iterating in developer mode, you can run the application as a
conventional jar file.

First compile it:

> ./mvnw package

Then run it:

> java -jar ./target/quarkus-app/quarkus-run.jar

Have a look at how fast it boots, or measure the total native memory consumption.

### 4.2 Run Native Executable

You can also create a native executable from this application without making any
source code changes. A native executable removes the dependency on the JVM:
everything needed to run the application on the target platform is included in
the executable, allowing the application to run with minimal resource overhead.

Compiling a native executable takes a bit longer, as GraalVM performs additional
steps to remove unnecessary codepaths. Use the  `native` profile to compile a
native executable:

> ./mvnw package -Dnative

After getting a cup of coffee, you'll be able to run this executable directly:

> ./target/getting-started-1.0.0-SNAPSHOT-runner
> 
>
## 5. **Miscellaneous**
run postgres:
>LC_ALL="C" /opt/homebrew/opt/postgresql@15/bin/postgres -D /opt/homebrew/var/postgresql@15

Kill process:

>sudo kill -15 95216
> 
>netstat -anv | grep 8080




