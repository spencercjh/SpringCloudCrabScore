FROM openjdk:8
VOLUME /tmp
ADD target/crabscore-gateway-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 14000
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]