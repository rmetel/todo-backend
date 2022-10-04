# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/todo-backend-*-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

# ------
#FROM maven:3.8.2-jdk-8
#
#WORKDIR /todo-backend
#COPY . .
#RUN mvn clean install
#EXPOSE 8080
#CMD mvn spring-boot:run

# terminal
# docker build -t todo-backend -f todo-backend.dockerfile .
# docker run --name todo-backend -dp 8080:8080 todo-backend

# docker hub
# docker build -t rmetel/todo-backend:1.0 -f docker/todo-backend.dockerfile .
# docker push rmetel/todo-backend:1.0
# docker run --name todo-backend -dp 8080:8080 rmetel/todo-backend:1.0
