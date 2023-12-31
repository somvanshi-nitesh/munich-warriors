# Use a base image with Java 17
FROM eclipse-temurin:21-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file from your local machine into the container
COPY target/munichwarriorsmanagement-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your Spring Boot application will run on (adjust to match your application's port)
EXPOSE 8080

# Command to run your Spring Boot application
CMD ["java", "-jar", "/app/app.jar"]
