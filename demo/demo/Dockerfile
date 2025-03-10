# Usar una imagen base de OpenJDK 17 con JDK para construir
FROM openjdk:17-jdk-slim AS build

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y el código fuente
COPY pom.xml .
COPY src ./src

# Construir el JAR usando Maven
RUN mvn clean package -DskipTests

# Verificar que el JAR se ha generado correctamente
RUN ls -l /app/target

# Usar una imagen base más ligera para la ejecución
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]