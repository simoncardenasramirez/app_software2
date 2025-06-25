# Usa una imagen base de OpenJDK para construir el contenedor
FROM openjdk:23

VOLUME /tmp

# Copia el archivo JAR del API Gateway desde tu máquina al contenedor
COPY target/api-gateway-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8081 que usará el API Gateway
EXPOSE 8081

# Comando para ejecutar la aplicación cuando se inicie el contenedor
ENTRYPOINT ["java", "-jar", "/app.jar"]