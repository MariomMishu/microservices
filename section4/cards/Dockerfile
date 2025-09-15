# Use OpenJDK as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/cards-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8090

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
