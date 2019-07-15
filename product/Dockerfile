FROM java:8-alpine

MAINTAINER XXX XXX@163.com

ADD web/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java" , "-jar" , "/app.jar"]