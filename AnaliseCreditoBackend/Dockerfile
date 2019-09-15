FROM openjdk:8-jdk-alpine

ADD target/*.war /build/app.war
WORKDIR /build/
EXPOSE 8080
CMD java -jar app.war