# Etapa de build con Maven y JDK 17
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos pom.xml primero para aprovechar la cache de dependencias
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline || true

# Ahora copiamos el código fuente
COPY src ./src
RUN mvn -q -DskipTests package

# Etapa final: imagen ligera con JDK 17
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

#FROM maven:3.9.8-eclipse-temurin-17 as build
#WORKDIR /app
#COPY pom.xml .
#RUN mvn -q -e -DskipTest package -U || true
#COPY src ./src
#RUN mvn -q -DskipTest package || true
#
#FROM eclipse-temurin:17-jdk-alpine
#WORKDIR /app
#COPY --from=build /app/target/*.jar app.jar
#EXPOSE 8081
#ENTRYPOINT["java", "jar", "/app/app.jar"]
