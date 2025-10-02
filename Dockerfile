# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set environment variable for Spring Boot
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""

# Set the working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy source code
COPY src ./src

# Make mvnw executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port Render will use
EXPOSE 8080

# Run the jar file
CMD ["sh", "-c", "java $JAVA_OPTS -jar target/*.jar"]
