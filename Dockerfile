# Etapa 1: Construcción
FROM maven:3.9.5-eclipse-temurin-17 AS builder

WORKDIR /app

# Copiar los archivos del proyecto al contenedor
COPY . .

# Ejecutar el empaquetado de Maven
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=builder /app/target/Api-ToDoApp-0.0.1-SNAPSHOT.jar app.jar

# Copiar el archivo de configuración (application.properties o application.yml)
COPY src/main/resources/application.properties /app/config/application.properties

# Exponer el puerto 8080
EXPOSE 8086

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]