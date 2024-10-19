FROM amazoncorretto:17

ARG JAR_FILE=target/*.jar

COPY target/demo-0.0.1-SNAPSHOT.jar application.jar

ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]
