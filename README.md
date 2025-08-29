# AutoDealer Management System

## Project Overview
AutoDealer Management System is a secure, backend Spring Boot application designed to facilitate automobile dealer management. This system manages dealer profiles, vehicle inventories, and payment processing with JWT-based authentication and RESTful APIs. It simulates real-world dealer operations with asynchronous payment status updates and comprehensive security.

---

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Security](#security)
- [Testing](#testing)
- [Swagger API Documentation](#swagger-api-documentation)
- [Contributing](#contributing)
- [License](#license)

---

## Features
- User registration and authenticated login functionality with JWT token issuance.
- Unsecured `/auth` endpoints for registration and login.
- Secure endpoints for managing dealers, vehicles, and payments.
- Dealer management with profile creation including subscription types.
- Vehicle inventory linked to dealers with status tracking.
- Payment initiation with asynchronous status update simulation (PENDING -> SUCCESS).
- REST API documentation generated and exposed via Swagger UI.
- JWT authentication filter integrated to protect API endpoints.
- Uses Spring Data JPA for database access with PostgreSQL (configurable).
- Asynchronous processing for payment status updates using Spring's `@Async`.
- Custom exception handling and input validation.

---

## Technologies Used
- Java 21
- Spring Boot 3.5.5
- Spring Security with JWT
- Spring Data JPA
- Hibernate ORM
- PostgreSQL (or any JPA-compatible database)
- Maven
- Swagger / Springdoc OpenAPI
- Asynchronous processing with `@Async`

---

## Getting Started

### Prerequisites
- Java 21 JDK installed
- Maven installed
- PostgreSQL database (or equivalent) running and configured
- IDE like IntelliJ IDEA or VSCode

### Setup Instructions
1. Clone the repository  
$ git clone https://github.com/MadathaGanesh/AutoDealer-Management-System.git

2. Configure your database in `src/main/resources/application.properties`  

3. Configure JWT secret and expiration (recommended to add in `application.properties` or environment variables)  

4. Build and run the application:  

5. Access API documentation at:  
http://localhost:8080/swagger-ui/index.html


---

## API Endpoints Summary

| Endpoint                 | Method | Description                      | Auth Required |
|--------------------------|--------|---------------------------------|--------------|
| `/auth/register`         | POST   | Register new user                | No           |
| `/auth/login`            | POST   | Login and get JWT token          | No           |
| `/savedealerdata`        | POST   | Create new dealer                | Yes          |
| `/addnewVehicle`         | POST   | Add a vehicle linked to a dealer| Yes          |
| `/api/payments/initiate` | POST   | Initiate payment                 | Yes          |
| (Other secured APIs)      | GET/PUT/DELETE | Manage dealers, vehicles, payments | Yes  |


## Security
- Uses JWT for stateless authentication.
- JWT tokens issued on `/auth/login`.
- JWT token must be sent in HTTP header:

Authorization: Bearer <token>
- `/auth/**` endpoints are publicly accessible.
- All other endpoints require a valid JWT token.
- Swagger UI paths are publicly accessible for testing.

---

## Testing
- Use Postman or curl for manual API testing.
- Register, then login to get JWT token.
- Pass JWT token to secured endpoints in `Authorization` header.
- Example Postman payloads for Dealer, Vehicle, and Payment available in the repo.
- Test asynchronous payment status updates by checking payment after a few seconds.

---

## Swagger API Documentation
- Swagger UI is configured and available at:  
http://localhost:8080/swagger-ui/index.html

- Provides interactive exploration and testing of all REST APIs.
- Documentation is automatically generated using Springdoc OpenAPI.

---

## Contributing
- Contributions are welcome!  
- Fork the repo, create a feature branch, and submit a pull request.
- Please include tests and ensure coding best practices.

---

## Contact
For questions or support, please contact:  
Madatha Ganesh - ganeshmadatha159@gmail.com

---

*This README was generated to provide a comprehensive overview of the AutoDealer Management System backend project.*

