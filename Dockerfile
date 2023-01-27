FROM openjdk:11

COPY pom.xml pom.xml
COPY . .

ENV     ip\
    username\
    database\
    password

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]