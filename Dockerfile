FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:17-jdk-alpine
ENV DB_PASSWORD=somePassword999
ENV JWT_TOKEN_SIGNING_KEY=53A73E5F1C4E0A2D3B5F2D784E6A1B423D6F247D1F6E5C3A596D635A75327855
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
ENTRYPOINT ["java","-jar","/app/*.jar"]