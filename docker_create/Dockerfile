FROM aarch64/maven:jdk-8
VOLUME /tmp
ADD assessment1-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]