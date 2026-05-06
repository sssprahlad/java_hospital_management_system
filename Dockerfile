

FROM maven:3.8.3-openjdk-17 AS build

# set working directory first
WORKDIR /app

# copy jar
COPY . /app/

# change ownership (important)
RUN mvn clean package

FROM openjdk:17-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar", "myApp.jar"]

