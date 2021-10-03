#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build

WORKDIR /usr/src/backend/
COPY src ./src
COPY pom.xml .

RUN mvn -f ./pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim

WORKDIR /usr/src/backend/

COPY --from=build /usr/src/backend/target/ .
COPY --from=build /usr/src/backend/target/java-tests-1.0-SNAPSHOT.jar ./app.jar

CMD ["java","-jar","app.jar"]