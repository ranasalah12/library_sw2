FROM openjdk:21
COPY target/Library-Management-0.0.1-SNAPSHOT.jar myApp/Library-Management.jar
ENTRYPOINT ["java","-jar","myApp/Library-Management.jar"]