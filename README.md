Task Management API

A RESTful API built with Spring Boot, Maven, and H2 database using Java 17. Implements JWT authentication and CRUD operations for task management.


## ** Run with Docker (Recommended) ** 

1) Install Docker: Get Docker
2) Pull and run the Docker image:
    docker run -p 8080:8080 1nv0ker7/task-management-api:latest


3) Test the API:
    -> Login to get JWT token:
        curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"username":"admin1","password":"secret1"}'
    -> Get all tasks (replace <your-jwt-token> with the token from the login response):
        curl -X GET http://localhost:8080/api/tasks -H "Authorization: Bearer <your-jwt-token>"





## ** Run from Source **

* Prerequisites
    Java 17 (e.g., Temurin/OpenJDK)
    Maven
    Optional: IDE (IntelliJ, VS Code)

* Steps

1) Clone the repository:
    git clone https://github.com/1nV0ker7/task-management-api.git
    cd task-management-api

OR download the ZIP from GitHub and extract it.

2) Install dependencies:
    mvn clean install


3) Run the application:
    mvn spring-boot:run


4) Test the API:
    -> Login to get JWT token:
        curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"username":"admin1","password":"secret1"}'
    -> Get all tasks (replace <your-jwt-token> with the token from the login response):
        curl -X GET http://localhost:8080/api/tasks -H "Authorization: Bearer <your-jwt-token>"
    



5) Access the H2 Console (optional):
    URL: http://localhost:8080/h2-console
    JDBC URL: jdbc:h2:mem:testdb
    Username: sa
    Password: (leave blank)



CI/CD
This project uses GitHub Actions for CI/CD. The pipeline builds and tests the application on every push to the master branch. Check the Actions tab for pipeline runs.
