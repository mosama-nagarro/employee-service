FROM maven:3.9.2-eclipse-temurin-17 AS build

WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Create a non-root user with home directory /app
RUN adduser -D -h /app nonrootuser

# Install bash and netcat for inline wait as mysql takes time to initialize
RUN apk add --no-cache bash busybox-extras

COPY --from=build /build/target/employee-service-1.0.0.jar app.jar

USER nonrootuser

ENTRYPOINT ["sh", "-c", "\
  echo 'Waiting for MySQL to be ready...'; \
  while ! nc -z mysql 3306; do \
    sleep 1; \
  done; \
  echo 'MySQL is up!'; \
  exec java -jar app.jar \
"]
