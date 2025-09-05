# ----------------------------
# Stage 1: Build the WAR file
# ----------------------------
FROM maven:3.8.6-openjdk-11 AS builder

# Set working directory
WORKDIR /app

# Copy Maven config and source code
COPY pom.xml .
COPY src ./src

# Build WAR (skip tests in Docker to speed up, since tests run in Jenkins)
RUN mvn clean package -DskipTests

# ----------------------------
# Stage 2: Run in Tomcat
# ----------------------------
FROM tomcat:9.0-jdk11

# Set working directory to Tomcat webapps
WORKDIR /usr/local/tomcat/webapps

# Remove default ROOT app
RUN rm -rf ROOT

# Copy WAR file from builder stage
COPY --from=builder /app/target/NumberGuessGame.war ROOT.war

# Expose port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
