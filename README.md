# User Service

This repository contains the source code for a user service application. The application provides user management and authentication functionalities.

## Technologies Used

- Java
- Spring Boot
- PostgreSQL
- BCryptPasswordEncoder

## Description

The user service is a Spring Boot application that allows users to register, login, and manage their profiles. It provides secure password storage using the BCryptPasswordEncoder and utilizes PostgreSQL as the database for user storage.

The application consists of the following components:

- **Controller:** Contains the API endpoints for user registration, login, and profile management.
- **Service:** Implements the business logic for user operations and interacts with the database.
- **Repository:** Handles database operations for user entities.
- **Model:** Defines the user entity and DTO (Data Transfer Object) classes.
- **Security:** Provides authentication and password encoding using BCryptPasswordEncoder.

## Prerequisites

Before running the application, ensure that you have the following installed:

- Java Development Kit (JDK)
- PostgreSQL database
- Maven (for dependency management)

## Getting Started

To get started with the user service application, follow these steps:

1. Clone the repository:

bash
  git clone https://github.com/jemhik/user-service.git
  
Create a PostgreSQL database and configure the connection details in the application.properties file.

Build the project using Maven:

bash
Copy code
cd user-service
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run

The application should now be running on http://localhost:8080.

## API Endpoints

The following API endpoints are available:

- POST /user/register: Register a new user by providing the necessary user details.
- POST /user/login: Authenticate a user by providing the email and password.
- GET /user/profile: Retrieve the user profile information for the authenticated user.
- POST /user/profile: Update the user profile information for the authenticated user.
- GET /user/logout: Log out the authenticated user.

## Contributing

Contributions to the user service application are welcome. If you find any bugs or want to suggest improvements, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or inquiries, feel free to contact me at sergij2003ua@gmail.com

