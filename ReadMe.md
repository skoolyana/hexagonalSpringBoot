# rest-spring-boot-hexagonal-architecture

This project is to expose my interpretation of the hexagonal architecture, under spring-boot framework.

The diagram of the hexagonal architecture relies on the following:

![Hexagonal architecture diagram](img/hexagonal-architecture.png)

I have tried to take a diagram that I have seen common on different articles, even though I saw port/adapter to be swap.


This project is following this diagram on spring-boot framework.

## Application diagrams

On this I was doing the following approach diagram:

![Application diagram](img/hexagonal-arch-spring-naspredam.png)

Where we have as part of the application is:

- REST implementation
- Database connection


## Project Details

## Prerequisites  


1) Java JDK 17: Ensure you have Java Development Kit (JDK) 17 installed on your system. This version is    
   specified in the java.version property of  pom.xml file.

2) Apache Maven 3.8.1: Maven is used as the build and dependency management tool for your project. You can     
   download and install Maven from the official Apache Maven website.

3) Database: The project uses an H2 in-memory database for runtime scope. It's specified as a dependency in
   pom.xml file. 

4) Lombok: Lombok is used for reducing boilerplate code in Java classes. It's specified as a dependency and   
   configured in your Maven plugins. Lombok does not require additional installation steps; it works as an          
   annotation processor during compilation.

5) MapStruct: MapStruct is a code generator for Java bean mappings. It's used for mapping between different    
   layers of your application. MapStruct is specified as a dependency and configured in your Maven plugins.   
   It works as an annotation processor during compilation.


## Installation

1) Clone the repository

   git clone https://github.com/skoolyana/hexagonalSpringBoot.git

2) Change directory to project folder

   cd hexagonalSpringBoot

3) Build the project

   mvn clean install

## Running The Spring Boot Application

1) cd application

2) mvn spring-boot:run


## Configuration

1) Create a application.properties file in the applications module in  src/main/resources directory and add   
   your database configuration.


## Code Quality Checks

   To run code quality checks using Checkstyle, execute the following Maven command in your project 
   directory:

   mvn -P Run-Code-Checks checkstyle:check



## Running Tests

   To run unit tests for your project, execute the following Maven command in your project directory:

   mvn test



## Code Coverage with JaCoCo

### Prerequisites
   Make sure you have JaCoCo installed and configured in your project. If not, you can add the JaCoCo plugin 
   to your Maven build configuration.

### Generating Code Coverage Report
   To generate code coverage reports for your project, execute the following Maven command in your project 
   directory:

   mvn clean test jacoco:prepare-agent install jacoco:report


### Viewing Code Coverage Report

   After generating the code coverage report, you can open the HTML report in your browser to view the 
   detailed coverage information. Simply open the index.html file in the target/site/jacoco directory for 
   each module.

