FROM openjdk:21-jdk-slim as base
LABEL authors="esoalahy josefa"

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean install -DskipTests

EXPOSE 8080

FROM base as dev

CMD ./mvnw spring-boot:run

FROM base as prod

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/ton-jar-final.jar"]




