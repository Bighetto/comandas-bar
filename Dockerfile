# Use a imagem oficial do OpenJDK 11
FROM openjdk:11-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copie o código fonte da sua aplicação para o diretório de trabalho
COPY . /app

# Compile sua aplicação e gere o jar
RUN ./mvnw clean install

# Copie o arquivo jar da sua aplicação para o diretório de trabalho
COPY target/your-app.jar /app/your-app.jar

# Defina a variável de ambiente para a aplicação
ENV JAVA_OPTS=""

# Execute a aplicação como um processo sozinho
CMD java $JAVA_OPTS -jar your-app.jar



#ENV     ip\
#    username\
#    database\
#    password