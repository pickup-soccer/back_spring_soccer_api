FROM openjdk:17-jdk-slim

COPY build/libs/go_play_footbik-api-0.0.1-SNAPSHOT.jar go_play_footbik-api.jar

ENTRYPOINT ["java", "-jar", "go_play_footbik-api.jar"]