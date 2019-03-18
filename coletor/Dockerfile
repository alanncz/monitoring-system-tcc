FROM openjdk:8-jdk-alpine
COPY target/collector-jar-with-dependencies.jar collector-jar-with-dependencies.jar
ENTRYPOINT ["java", "-jar", "collector-jar-with-dependencies.jar"]
