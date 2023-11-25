#FROM adoptopenjdk/maven-openjdk11
FROM csanchez/maven:3.9.5-eclipse-temurin-11

WORKDIR /opt/app

COPY . ./

RUN mvn clean install -DskipTests

RUN cp ./target/todo-backend-*.jar ./app.jar

RUN echo "<version>$(grep -oPm2 "(?<=<version>)[^<]+" pom.xml | sed -n 2p)</version>" > meta.txt

RUN echo "<branch>$(git rev-parse --abbrev-ref HEAD)</branch>" >> meta.txt

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
