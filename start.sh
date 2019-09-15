#!/usr/bin/env bash
echo "-----> BUILD BACKEND <-----"
cd AnaliseCreditoBackend
mvn clean install -DskipTests
docker build -t joaojoseleal/analise-credito-backend .

echo "----> START DOCKER <----"
cd ../
docker-compose up
echo "----> FINISH <----"