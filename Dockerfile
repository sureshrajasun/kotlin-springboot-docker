FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/kotlin-spring-demo-0.0.1-SNAPSHOT.jar kotlin-spring-demo.jar
ENTRYPOINT ["java", "-jar", "kotlin-spring-demo.jar"]