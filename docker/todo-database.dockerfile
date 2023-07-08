FROM mysql:8.0.30

ENV MYSQL_DATABASE todo-db
ENV MYSQL_ROOT_PASSWORD todo

VOLUME "C:/Users/ddr_r/databases/todo-db:/var/lib/mysql:rw"

EXPOSE 3306

# terminal
# docker run --name db-local -dp 3306:3306 db-local