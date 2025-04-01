# Backend für Applikationen realisieren

This is a RESTful API built with **Java Spring Boot 3.2.4**, designed to manage products and categories. It includes full JWT-based authentication, user role management, and Swagger/OpenAPI documentation.

---

## 📦 Tech Stack

- **Backend:** Spring Boot 3.2.4
- **Database:** MariaDB (via Docker)
- **ORM:** Spring Data JPA (Hibernate)
- **Security:** Spring Security + JWT
- **Documentation:** SpringDoc OpenAPI 2.x (Swagger)
- **Build Tool:** Maven
- **Seeding:** Flyway (`V1__init.sql`)
- **DTO Mapping:** MapStruct
- **Others:** Lombok, Validation (Jakarta)

---

## 🔐 Authentication & Authorization

- JWT is used to secure protected endpoints.
- Two roles: `USER` (default) and `ADMIN`.
- Public endpoints:
    - `POST /auth/register`
    - `POST /auth/login`
    - `GET /products`
    - `GET /categories`

- Only authenticated users can create, update or delete data.
- Only `ADMIN` users can promote other users.

---

## 🚀 Features

- Register new users (`/auth/register`)
- Secure login with token (`/auth/login`)
- Manage products and categories (CRUD)
- Promote users to admin role (`/role/promote`)
- Seed database with initial data using Flyway
- View and test all endpoints via Swagger UI

---

## 🛠 Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/augi07/UK-295.git
cd UK-295
```
---
##  Start MariaDB and Adminer

Make sure Docker is installed, then run:

```bash
docker-compose up -d
```

### This starts:

`mariadb:10.11 on port 3307`
and
`adminer on port 8090`

## Run the application

You can run the Application via following command or by just at the Top right run Application
```bash
./mvnw spring-boot:run
```

The Swagger UI will be available on:
```bash
http://localhost:8080/swagger-ui.html
```

---

## 📄 OpenAPI Documentation
All endpoints are documented with Swagger annotations.

http://localhost:8080/v3/api-docs

also here in this Repository the `docs/openAPI.json` File


---

## Ports

MariaDB: `http://localhost:3307`

Adminer: `http://localhost:8090`

---

## 👤 Author

Augusto Hasenbalg  
Berufsschule Bern | üK 295  
📅 Release Date: `2025-04-02`

---