FROM gradle:6.3-jdk11 AS build
RUN mkdir /apps
COPY --chown=gradle:gradle . /apps
WORKDIR /apps
RUN gradle build

FROM openjdk:11-jre
COPY --from=build /apps/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
