FROM openjdk:22-jdk

# Copy the JAR file into the container
ADD target/employee-app.jar employee-app.jar

# Expose port 80
#EXPOSE 9090

# Define the entry point to run your application#ENTRYPOINT [“java”, “-jar”, “app-v3.jar”]
ENTRYPOINT ["java","-jar","employee-app.jar"]