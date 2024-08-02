FROM openjdk:17
EXPOSE 9090
ADD target/boot-docker.jar boot-docker.jar
ENTRYPOINT ["java", "-jar", "/boot-docker.jar"]