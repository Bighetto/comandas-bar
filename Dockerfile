# Use a imagem oficial do OpenJDK 11
FROM openjdk:11-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copie o código fonte da sua aplicação para o diretório de trabalho
COPY . /app
COPY pom.xml .
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline

# Compile sua aplicação e gere o jar
RUN mvn clean install package

# Copie o arquivo jar da sua aplicação para o diretório de trabalho
COPY ./target/comandas-bar-1.0.jar /app/comandas-bar.jar

# Execute a aplicação como um processo sozinho
CMD ["java", "-jar", "comandas-bar.jar"]

