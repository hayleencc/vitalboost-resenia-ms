FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

COPY --from=build /app/target/resenia-ms-0.0.1-SNAPSHOT.jar resenia-ms.jar
RUN chown spring:spring resenia-ms.jar

USER spring

EXPOSE 8083
ENTRYPOINT ["java","-jar","resenia-ms.jar"]
