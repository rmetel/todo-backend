FROM nginx

EXPOSE 80

RUN rm /usr/share/nginx/html/*

COPY /nginx/default.conf /etc/nginx/nginx.conf

CMD [ "nginx", "-g", "daemon off;" ]

# terminal
# docker build -t todo-nginx -f todo-nginx.dockerfile .
# docker run --name todo-nginx -dp 80:80 todo-nginx