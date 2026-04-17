# User Management System

## Description
This project is a RESTful API-based User Management System built with **Java** and **Spring Boot**. It allows users to perform CRUD (Create, Read, Update, Delete) operations on user data. The application uses **Spring Data JPA** for database interactions and **Lombok** to reduce boilerplate code.

## Features
- Create a new user
- Retrieve all users
- Update user details
- Delete a user
- Exception handling for invalid operations

## Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Lombok**
- **Maven**
- **Jackson** (for JSON serialization/deserialization)

## Endpoints
### Base URL: `/api/v1/users`

| HTTP Method | Endpoint               | Description              |
|-------------|------------------------|--------------------------|
| POST        | `/createUser`          | Create a new user        |
| GET         | `/`                    | Retrieve all users       |
| PUT         | `/{id}`                | Update user by ID        |
| DELETE      | `/{id}`                | Delete user by ID        |

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven
- A database (e.g., MySQL, PostgreSQL, H2)

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
