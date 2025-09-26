# Use OpenJDK as the base image
FROM openjdk:17-jdk-slim

# MAINTAINER instruction is deprecated in favor of using label
# MAINTAINER bs0842
#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="bs0842"

# Copy the jar file into the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 8090

# Run the jar file
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]