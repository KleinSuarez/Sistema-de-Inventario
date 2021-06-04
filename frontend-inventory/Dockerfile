FROM node:10-alpine as build-step
RUN mkdir -p /app
WORKDIR /app
COPY package.json /app
RUN npm install
RUN npm run build --prod
FROM nginx:1.17.1-alpine
COPY ./dist/fronted-inventory/ /usr/share/nginx/html