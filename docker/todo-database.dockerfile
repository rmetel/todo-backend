FROM mysql

ENV MYSQL_ROOT_PASSWORD todo
ENV MYSQL_DATABASE todo

EXPOSE 3306

# terminal
# docker run --name db-local -dp 3306:3306 db-local