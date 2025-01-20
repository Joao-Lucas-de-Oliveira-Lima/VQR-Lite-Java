# VQR-Lite

## Table of Contents

- [About](#about)
- [Getting Started](#getting-started)
- [Usage](#usage)

## About <a name = "about"></a>

A REST API for ticket and rodeo event management, in a LITE version created for the PIES1 discipline (Integrated Software Engineering Project I). The project requirements included building an API in JAVA, for which the Spring framework was chosen.
The API itself is quite old and one of the first I developed during college. As a result, basic concepts like exception handling, documentation, and similar practices were not part of my knowledge at the time and were not implemented.

---

## Getting Started

### Prerequisites

- Docker Desktop
- JDK 21

### Installation

1. **Start the PostgreSQL database:**
   ```bash
   docker compose up -d
   ```

2. **Compile the application:**
   ```bash
   ./mvnw compile
   ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

---

## Usage
Once the application starts, it will be available at: http://localhost:8080

### API Endpoints

#### Events

- **GET** `/events?eventOwnerId="UUID"` - List all events
  - Query Parameters:
    - `eventOwnerId` (optional): Filter events by the owner’s UUID.

- **POST** `/events` - Create a new event
  - Request Body:
    ```json
    {
      "name": "Example Event",
      "numberOfInitialPasswords": 100,
      "beginDateTime": "2025-01-20T10:30:00",
      "location": {
        "county": "Example County",
        "state": "Example State"
      },
      "eventOwnerId": "123e4567-e89b-12d3-a456-426614174000"
    }
    ```

- **GET** `/events/{id}` - Get event by ID
  - Response:
    ```json
    {
      "id": "123e4567-e89b-12d3-a456-426614174000",
      "name": "Sample Event",
      "numberOfInitialEventPasswords": 100,
      "numberOfTotalEventPasswords": 150,
      "totalNumberOfTimesMorePasswordsWereAdded": 2,
      "beginDateTime": "2025-01-20T10:30:00",
      "location": {
        "county": "Sample County",
        "state": "Sample State"
      },
      "eventOwner": {
        "id": "987e6543-e21b-12d3-a456-426614174111",
        "name": "John Doe",
        "email": "johndoe@example.com",
        "phoneNumber": "+1234567890"
      }
    }
    ```

- **PATCH** `/events/{id}` - Modify an event

---

#### Clients

- **GET** `/clients?name="string"` - List all clients
  - Query Parameters:
    - `name` (optional): Filter clients by name.

- **POST** `/clients` - Create a new client
  - Request Body:
    ```json
    {
      "name": "John Doe",
      "email": "johndoe@example.com",
      "phoneNumber": "12123456789"
    }
    ```

- **GET** `/clients/{id}` - Get client by ID
  - Response:
    ```json
    {
      "id": "123e4567-e89b-12d3-a456-426614174000",
      "name": "Jane Doe",
      "email": "janedoe@example.com",
      "phoneNumber": "12123456789"
    }
    ```

- **PATCH** `/clients/{id}` - Modify a client

- **DELETE** `/clients/{id}` - Delete a client

---

#### Passwords

- **GET** `/passwords?eventId="UUID"&wasItSold="boolean"` - List all passwords for an event
  - Query Parameters:
    - `eventId` (optional): Filter by event ID.
    - `wasItSold` (optional): Filter by sale status.

- **GET** `/passwords/{id}` - Get password by ID
  - Response:
    ```json
    {
      "id": "123e4567-e89b-12d3-a456-426614174000",
      "puller": "John Doe",
      "pullerHorse": "Thunder",
      "grabber": "Jane Smith",
      "grabberHorse": "Lightning",
      "location": {
        "county": "Sample County",
        "state": "Sample State"
      },
      "passwordNumber": 123,
      "bullTv": true,
      "wasItSold": false,
      "payment": {
        "paymentMethod": "Credit Card",
        "amount": 100.0
      }
    }
    ```

- **PATCH** `/passwords/{id}` - Modify a password
  - Request Body:
    ```json
    {
      "puller": "John Doe",
      "pullerHorse": "Thunder",
      "grabber": "Jane Smith",
      "grabberHorse": "Lightning",
      "location": {
        "county": "Sample County",
        "state": "Sample State"
      },
      "bullTv": true,
      "wasItSold": false,
      "payment": {
        "paymentMethod": "Credit Card",
        "amount": 100.0
      }
    }
    ```

---

#### Finances

- **GET** `/finances?eventId="UUID"` - Get financial reports for events
  - Response:
    ```json
    {
      "id": "123e4567-e89b-12d3-a456-426614174000",
      "numberOfInitialPasswords": 100,
      "totalPasswordsAdded": 50,
      "totalNumberOfPasswords": 150,
      "totalPasswordsSold": 120,
      "totalOfBullsTv": 30,
      "totalMoney": 5000.50,
      "totalAmountRaisedViaPix": 2000.00,
      "totalAmountOfCashCollected": 1500.00,
      "totalAmountOfMoneyCollectedViaCard": 1500.50
    }
    ```

---

#### Authentication

- **POST** `/auth/login` - User login
  - Request Body:
    ```json
    {
      "login": "exampleUser",
      "password": "examplePassword"
    }
    ```
  - Response:
    ```json
    {
      "token": "exampleToken"
    }
    ```

- **POST** `/auth/register` - User registration
  - Request Body:
    ```json
    {
      "login": "exampleUser",
      "password": "examplePassword",
      "role": "ADMIN"
    }
    ```
  - Response:
    - **200 No Content**

