FROM adoptopenjdk/maven-openjdk11

WORKDIR /opt/app

COPY . ./

COPY ./pom.xml ./

RUN mvn clean install -DskipTests

RUN cp ./target/todo-backend-1.3.*-SNAPSHOT.jar ./app.jar

EXPOSE 5000

ENTRYPOINT ["java","-jar","app.jar"]

# terminal
# docker build -t todo-backend -f docker/todo-backend.dockerfile .
# docker run --name todo-backend -dp 5000:5000 todo-backend

# docker hub
# docker build -t ddrram/todo-backend:1.1.0 -f docker/todo-backend.dockerfile .
# docker push ddrram/todo-backend:1.1.0
# docker run --name todo-backend -dp 8080:8080 ddrram/todo-backend:1.1.0

# docker credentials store
# docker --config .docker login https://index.docker.io/v1/
