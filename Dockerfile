FROM maven:3.8.3-openjdk-17 AS BUILD
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn --file /usr/src/app/pom.xml clean package

FROM openjdk:17
COPY --from=build /usr/src/app/target/file_uploader_backend-0.0.1-SNAPSHOT.jar /usr/app/file_uploader_backend-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/app/file_uploader_backend-0.0.1-SNAPSHOT.jar"]