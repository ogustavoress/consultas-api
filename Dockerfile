# Etapa 1: Build
FROM maven:3.9.11-eclipse-temurin-17

COPY . /opt/app

WORKDIR /opt/app

RUN mvn clean package

CMD ["java", "-jar", "target/app.jar"]

# Etapa 2: Runtime