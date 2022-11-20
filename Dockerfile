FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 8080
ADD build/libs/VMProvisioningService-0.0.1-SNAPSHOT.jar VMProvisioningService.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/VMProvisioningService.jar"]