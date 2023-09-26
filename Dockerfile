FROM eclipse-temurin:17-jdk-alpine
COPY target/DivesAnimaApi-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "DivesAnimaApi-0.0.1-SNAPSHOT.jar"]