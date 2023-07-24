#!/bin/sh

export TODO_FRONTEND_VERSION=$(echo $(cat ~/logs/todo-frontend.log))

cd ~/git/todo-backend || exit

git pull && docker-compose -f docker/docker-compose-prod.yaml up -d