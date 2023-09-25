#  💻 ARCHETYPE SPRINGBOOT 💻

![ASF Jira](https://img.shields.io/endpoint?url=https%3A%2F%2Fmaven.apache.org%2Fbadges%2Fasf_jira-ARCHETYPE.json)
![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/apache/maven.svg?label=License)
![Jenkins Status](https://img.shields.io/jenkins/s/https/ci-maven.apache.org/job/Maven/job/maven-box/job/maven-archetype/job/master.svg?)

## 📚 Description

This project is an archetype that follows a specific 
organizational structure to facilitate application development for spring boot. A hexagonal
architecture implementing vertical slicing focused on microservices. 
The project structure is designed to clearly separate different 
layers of the application and promote good practices.

## 🚀 How to Use This Archetype

1. Install Java SE Development Kit 11.0.19. [Downloader](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html#license-lightbox)
2. Clone this repository: `git clone https://github.com/pragma/webflux-archetype.git`
3. Execute some [Gradle lifecycle tasks](https://docs.gradle.org/current/userguide/java_plugin.html#lifecycle_tasks) in order to check everything is OK:
    1. Create [the project JAR](https://docs.gradle.org/current/userguide/java_plugin.html#sec:jar) and other project artifacts:
       `./gradlew assemble --warning-mode all`
    2. Run the tests and plugins verification tasks:
       `./gradlew check --warning-mode all`
    3. Execute the main application entrypoint:
       `./gradlew build`
4. ¡Start developing!

   
## 📁 Project Structure

The skeleton uses the following folder structure::

**module**
- **application**: Application layer for controller DTOs.
    - **dtos**: Definition of requests and responses.
        - **requests**: Information reception formats that the controller will receive.
        - **responses**: Response format that will be displayed as the controller response.
    - **servicehandler**: Controllers and request handlers.
    - **dtomapper**: Mappers to convert between domain objects and DTOs.
    - **exception**: Generate and handle exceptions for the controller.

- **domain**: Domain logic and business entities.
    - **exceptions**: Generate and handle exceptions for domain logic.
    - **models**: Domain data models.
      - **ports**: Application ports.
        - **in**: Input ports for use cases.
        - **out**: Output ports for use cases.

  - **usecases**: Use cases of the application.
  - **utils**: Common utilities.
    - **constants**: Application constants.
    - **validations**: Data validations.

- **infrastructure**: Application infrastructure.
    - **adapters**: Adapters to connect with external systems.
      - **external**: External integrations.
      - **persistence**: Persistence layer.
    - **configurations**: Infrastructure-specific configurations.
    - **endpoints**: Communication endpoints.
        - **rest**: Controllers and routes for REST API.
        - **soap**: SOAP services implementation.
    - **entities**: Database entities.
    - **exceptionshandler**: Exception handling in the infrastructure.
    - **mappers**: Mappers to transform data between application and infrastructure.
  - **repositories**: Repositories to access data.
    - **mongodb**: Implementation of repositories for MongoDB.
    - **mysql**: Implementation of repositories for MySQL.

![img_1.png](diagram.png)

## 📦 Default Dependencies

* Springframework version 3.1.4: 
* Gradle 9.0.
* JUnit 5.

| Nombre                | Type           | Usage |
|-----------------------|----------------| ---- |
| data-jpa              | Implementation | ✔️   |
| web                   | Implementation | ✔️   |
| lombok                | CompileOnly    | ✔️   |
| mysql-connector-j     | RuntimeOnly    | ✔️   |
| postgresql            | RuntimeOnly    | ✔️   |
| mapstruct             | implementation | ✔️   |
| data-redis            | Implementation | ❌   |
| security              | Implementation | ❌   |
| netflix-eureka-client | Implementation | ❌   |
| oauth2-client         | Implementation | ❌   |
| data-mongodb          | Implementation | ❌   |
| log4j2                | Implementation | ❌   |
| graphql               | Implementation | ❌ |
| junit-jupiter         | Test           | ✔️   |
| junit-vintage         | Test           | ✔️   |
| h2                    | Test           | ✔️   |

> [Search for more dependencies in gradle](https://docs.gradle.org/current/javadoc/allpackages-index.html)

## 📢 Recommendations and tips for usage.

* You can delete the .gitkeep archive, it has no application functionality

* The implementation of the business logic, validations or everything related
to the base operation must go in the domain, it is expected that it will 
be isolated from technologies.

* In the .yml or .properties Variables are added for the connection to the database
or the project port is modified according to the environment **delete the
configuration file that you do not need.**
* When connecting for good practices It is recommended to use interfaces, for example in the application, create 
an interface and implement it in the relevant service class and then in infrastructure in the endpoint/controller 
inject the interface and thus it would be connected correctly, this applies to: 
  - Application-infrastructure.
  - Domain-application.
  - Infrastructure-domain.

⚠️ **Don't settle for what's there; if there's something unnecessary, rename it or remove it.**

⚠️ **The user module is an example that you can use as a base, if you don't need it you can delete it.**
