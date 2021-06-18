FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
ENV USE_PROFILE local
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${USE_PROFILE}", "-jar", "/app.jar"]
