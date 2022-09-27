FROM nginx

EXPOSE 80

RUN rm /usr/share/nginx/html/*

COPY nginx.conf /etc/nginx/nginx.conf

CMD [ "nginx", "-g", "daemon off;" ]

# terminal
# docker build -t todo-nginx -f todo-nginx.dockerfile .
# docker run --name todo-nginx -dp 80:80 todo-nginx

# docker hub
# docker build -t rmetel/todo-nginx:1.0 -f todo-nginx.dockerfile .
# docker run --name todo-nginx -dp 8080:8080 rmetel/todo-nginx:1.0
# docker push rmetel/todo-nginx:1.0