FROM csanchez/maven:3.9.5-eclipse-temurin-11

RUN apt-get update

RUN apt-get install nano

WORKDIR /opt/app

COPY .. ./

RUN mvn clean install -DskipTests

RUN cp ./target/todo-backend-*.jar ./app.jar

EXPOSE 5000

ENTRYPOINT ["java","-jar","app.jar"]

# terminal
# docker build -t todo-backend -f docker/todo-backend.dockerfile .
# docker run --name todo-backend -dp 5000:5000 todo-backend

# docker hub
# docker build -t ddrram/todo-backend:1.4.0 -f docker/todo-app/todo-backend.dockerfile .
# docker push ddrram/todo-backend:1.4.0

# docker credentials store
# docker --config .docker login https://index.docker.io/v1/
