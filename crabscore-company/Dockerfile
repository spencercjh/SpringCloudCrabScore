FROM openjdk:8
VOLUME /tmp
ADD target/crabscore-company-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8084
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]