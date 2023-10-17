# Use the official Maven image as the build image
FROM maven:3.6.3-jdk-8 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project's POM file
COPY pom.xml .

# Copy the source code
COPY src src

# Build the application
RUN mvn package

# Use a smaller JRE-based image for the final image
FROM openjdk:8-jre-slim

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/ConsolefileJavaCRUD-1.0-SNAPSHOT.jar /app/ConsolefileJavaCRUD.jar
#COPY --from=build /app/target/lib /app/lib

# Run the Java application when the container starts
CMD ["java", "-jar", "/app/ConsolefileJavaCRUD.jar"]
