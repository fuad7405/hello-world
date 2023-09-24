FROM gradle:8.2-jdk17-alpine AS build

ARG DEPLOYED_PATH=/opt/app

RUN mkdir ${DEPLOYED_PATH}

WORKDIR ${DEPLOYED_PATH}

COPY --chown=gradle:gradle . ${DEPLOYED_PATH}/

RUN gradle clean build --no-daemon

FROM openjdk:17-jdk-slim

ARG DEPLOYED_PATH=/opt/app

RUN mkdir ${DEPLOYED_PATH}

WORKDIR ${DEPLOYED_PATH}

ARG JAR_FILE=build/libs/*.jar

COPY --from=build ${DEPLOYED_PATH}/${JAR_FILE} ${DEPLOYED_PATH}/app.jar

ENV ACTIVE_PROFILE=${ACTIVE_PROFILE}

ENTRYPOINT ["java", "-Dspring.profiles.active=${ACTIVE_PROFILE}", "-jar", "app.jar"]