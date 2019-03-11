FROM openjdk:8
VOLUME /tmp
ADD target/crabscore-admin-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8081
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]