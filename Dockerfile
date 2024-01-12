FROM openjdk:17
ADD /target/MonitorSensors-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]