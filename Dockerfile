FROM java:8
ADD /target/demoCosmosDb-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]