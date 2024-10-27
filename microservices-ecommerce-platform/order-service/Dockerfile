# Start with a base image with Java installed
FROM openjdk:18-jdk-slim

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /microservices-ecommerce-platform

# Copy the service's built JAR file into the container
COPY target/order-service-1.0-SNAPSHOT.jar /microservices-ecommerce-platform/order-service.jar

# Expose the port that the service runs on (adjust as needed)
EXPOSE 8080

# Run the service
ENTRYPOINT ["java", "-jar", "/microservices-ecommerce-platform/order-service.jar"]
