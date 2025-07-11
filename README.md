# Task Management API

* The Task Management API is a Spring Boot-based RESTful application designed to handle user authentication with JWT and provide a foundation for task management features. 

* This project showcases Java development, Spring Security, Docker containerization, and GitHub Actions CI/CD integration.

## Features
* User authentication via /api/auth/login with JWT tokens.

* Secure API endpoints using Spring Security.

* Containerized deployment with Docker.

* Automated build and deployment pipeline with GitHub Actions.

## Flowchart
-- PlaceHolder for flowchart.png --

## Prerequisites

* Java 17

* Maven 3.8+

* Docker

* Git

* Postman (For API Testing)

## Installation

1) Clone the repository:
    * `git clone https://github.com/1nV0ker7/task-management-api.git`
    * `cd task-management-api`

2) Install dependencies:
    mvn clean install


3) Run the application:
    mvn spring-boot:run


4) Test the API:
    * Login to get JWT token:\
        `curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"secret"}' `
    * Get all tasks (replace *your-jwt-token* with the token from  the login response):\
        ` curl -X GET http://localhost:8080/api/tasks -H "Authorization: Bearer your-jwt-token" `

## Development Journey and Challenges

1) **Initial Build Failures**
    * Issue: `mvn clean install` failed due to missing `HttpSecurity` bean in `TestSecurityConfig`.
    * Resolution: Added `@EnableWebSecurity` and configured a `SecurityFilterChain` bean with `HttpSecurity` to resolve dependency injection errors.

2) **Authentication Failure**
    * Issue: POST `/api/auth/login` returned 403 Forbidden with an **IllegalArgumentException** due to no default password encoder.
    * Resolution: Configured a `BCryptPasswordEncoder` bean in `SecurityConfig.java` and encoded the password in `UserDetailsServiceImpl.java`

3) **GitHub Actions Build Failure**
    * Issue: The latest commit failed in GitHub Actions with "Process completed with exit code 1" due to unsynced local files.
    * Resolution: Synced all modified files with `git add` and `git push`, ensuring a successful CI/CD pipeline.

4) **Docker Port Conflict**
    * Issue: `docker run` failed with **"Bind for 0.0.0.0:8080 failed: port is already allocated"** due to an active container.
    * Resolution: Identified the container with `docker ps`, attempted `docker stop` (failed due to permissions), and resolved by `sudo reboot` to free the port.

## Future Enhancements
* **Database Integration:** Replace the in-memory, temporary database (`UserDetailsService`) with a persistent database(like MySQL).
* **Endpoint Upgrade:** Transition from `localhost` to a public domain or cloud-hosted endpoint (AWS, maybe) for real-world accessibility, including HTTPS support.
* **Role-Based Access Control:** Enhance Spring Security to support role-based access, allowing different permissions (e.g., admin vs. user) for task management.
* **API Documentation:** Generate interactive API documentation using Swagger/OpenAPI to improve developer experience.

### Acknowledgements
* xAI's Grok 3
* mermaid.live

## About Me
Checkout my [portfolio](https://1nv0ker7.github.io/Invoker.github.io/) for more projects!