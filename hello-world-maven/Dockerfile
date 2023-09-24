FROM maven:3.8.5-openjdk-17-slim AS build

ARG DEPLOYED_PATH=/opt/app

RUN mkdir ${DEPLOYED_PATH}

WORKDIR ${DEPLOYED_PATH}

COPY . ${DEPLOYED_PATH}/

RUN mvn clean package

FROM openjdk:17-jdk-slim

ARG DEPLOYED_PATH=/opt/app

RUN mkdir ${DEPLOYED_PATH}

WORKDIR ${DEPLOYED_PATH}

ARG JAR_FILE=target/*.jar

COPY --from=build ${DEPLOYED_PATH}/${JAR_FILE} ${DEPLOYED_PATH}/app.jar

ENV ACTIVE_PROFILE=${ACTIVE_PROFILE}

ENTRYPOINT ["java", "-Dspring.profiles.active=${ACTIVE_PROFILE}", "-jar", "app.jar"]