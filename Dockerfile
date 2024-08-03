FROM openjdk:17
EXPOSE 80
ADD target/boot-docker.jar boot-docker.jar
ENTRYPOINT ["java", "-jar", "/boot-docker.jar"]