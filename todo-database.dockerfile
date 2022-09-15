FROM mysql

ENV MYSQL_ROOT_PASSWORD todo
#ADD jsp_backup.sql /docker-entrypoint-initdb.d

EXPOSE 3306

# terminal
# docker run --name todo-database -dp 3306:3306 todo-database