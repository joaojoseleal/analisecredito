#!/bin/bash
echo "-----> BUILD BACKEND <-----"
cd AnaliseCreditoBackend
mvn clean install -DskipTests
docker build -t joaojoseleal/analise-credito-backend .

cd ../AnaliseCreditoFrontend
echo "----> BUILD FRONTEND <----"
docker build -t joaojoseleal/analise-credito-frontend .

echo "-----> START DOCKER <-----"
cd ../
docker-compose up
echo "----> FINISH <----"
