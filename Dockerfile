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
RUN mvn clean install

# Copie o arquivo jar da sua aplicação para o diretório de trabalho
COPY ./target/comandas-bar-0.0.1-SNAPSHOT.jar /app/comandas-bar.jar

# Defina a variável de ambiente para a aplicação
ENV JAVA_OPTS="database=loungebeach;ip=localhost;username=root;password=Fiap1234"

# Execute a aplicação como um processo sozinho
CMD java $JAVA_OPTS -jar comandas-bar.jar

