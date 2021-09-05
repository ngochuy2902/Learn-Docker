FROM gradle:7.1.1-jdk8 AS build
RUN mkdir /learndocker
WORKDIR /learndocker
COPY . .
RUN gradle bootJar

FROM openjdk:8-jre-slim
EXPOSE 8080
USER root
WORKDIR /learndocker
COPY --from=build /learndocker/build/libs/*.jar ./app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]