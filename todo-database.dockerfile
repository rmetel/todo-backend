FROM mysql

ENV MYSQL_ROOT_PASSWORD todo

#VOLUME C:/Users/rame/db:/var/lib/mysql:rw

#ADD jsp_backup.sql /docker-entrypoint-initdb.d

EXPOSE 3306

# terminal
# docker run --name db-local -dp 3306:3306 db-local