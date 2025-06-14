# Use a base image with Java 17
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the Maven build files
COPY pom.xml .
COPY src ./src

# Build the application with Maven
RUN apk add --no-cache maven && mvn clean package -DskipTests

# Copy the built JAR file
RUN cp target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]