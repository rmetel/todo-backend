#!/bin/sh

TODO_FRONTEND_VERSION=$(cat ~/logs/todo-frontend.log)
TODO_BACKEND_VERSION=$(cat ~/logs/todo-backend.log)

export TODO_FRONTEND_VERSION
export TODO_BACKEND_VERSION

cd ~/git/todo-backend || exit

git pull

docker-compose -f docker/docker-compose-prod.yaml up -d