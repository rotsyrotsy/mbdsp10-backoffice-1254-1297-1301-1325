# Use the official Grails image
FROM gradle:7.3.3-jdk11 AS build

# Set environment variables
ENV GRADLE_USER_HOME /home/gradle

# Create app directory
WORKDIR /app

# Copy the build.gradle and gradle files
COPY build.gradle gradlew gradlew.bat settings.gradle /app/
COPY gradle /app/gradle


# Convert Windows line endings to Unix line endings in gradlew
RUN sed -i 's/\r$//' /app/gradlew

# Copy the rest of the application files
COPY . /app

# Build the application
RUN ./gradlew clean assemble

# Use a base JDK image to run the application
FROM openjdk:11-jre-slim

# Set environment variables
ENV JAVA_OPTS=""

# Set the working directory
WORKDIR /app

# Copy the built jar file
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Expose port 8080
EXPOSE 8080
 
# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
