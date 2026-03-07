
#Start with a base image containing Java runtime
FROM eclipse-temurin:17-jdk-jammy

#Information about who maintain this code
MAINTAINER Akash

#Add the application jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]