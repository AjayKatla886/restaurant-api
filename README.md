# 🍽️ Restaurant API - Spring Boot Backend

This is a RESTful API backend for a restaurant booking system built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. It is part of the **Noa by September** full stack project targeting customers in Bangkok.

---

## 🔧 Features

- ✅ User Registration
- ✅ User Login with email and phone
- ✅ View all users
- ✅ Update or Delete user by email
- ✅ Input validation with Jakarta Validation
- ✅ API documentation using Swagger UI
- ✅ MySQL database integration

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot 3.5.3
- Spring Web & Data JPA
- MySQL
- Swagger (Springdoc OpenAPI)
- Maven
- Git & GitHub

---

## 🧪 Running Locally

### 1️⃣ Prerequisites

- Java 17+
- MySQL running (with a DB named `restaurant_db`)
- Maven

### 2️⃣ Clone the Repo

```bash
git clone https://github.com/AjayKatla886/restaurant-api.git
cd restaurant-api

Configure DB in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

Run The Application
mvn spring-boot:run
