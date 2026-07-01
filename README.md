# Student Management CRUD API

A RESTful CRUD API built using **Spring Boot**, **Spring Data JPA**, and **MySQL** for managing student records.

This project supports:
- Create Student
- Read Student
- Update Student
- Hard Delete
- Soft Delete

---

## Features

- Create Student
- Get All Students
- Get Student By ID
- Update Student
- Hard Delete Student
- Soft Delete Student
- Custom API Response Structure
- MySQL Integration
- Spring Data JPA

---

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok

---

## Project Structure

```bash
src/main/java/com/springboot/CRUD_springboot/
│
├── controller
├── entity
├── repository
├── service
├── utilities
└── CrudSpringbootApplication.java
```

---

## API Base URL

```bash
http://localhost:8080/students
```

---

# API Endpoints

## 1. Create Student

```http
POST /create
```

Request Body:

```json
{
  "name": "Shivam Mishra",
  "age": 23,
  "email": "shivam@gmail.com",
  "rollNo": 101,
  "subject": "CSE"
}
```

---

## 2. Get All Students

```http
GET /get-all
```

Returns all students where:

```java
deleted = false
```

---

## 3. Get Student By ID

```http
GET /get?id=1
```

Example:

```bash
http://localhost:8080/students/get?id=1
```

---

## 4. Update Student

```http
PUT /update?id=1
```

Request Body:

```json
{
  "name": "Updated Name",
  "age": 24,
  "email": "updated@gmail.com",
  "rollNo": 102,
  "subject": "ECE"
}
```

---

## 5. Hard Delete Student

```http
DELETE /delete?id=1
```

This permanently deletes student data from database.

---

## 6. Soft Delete Student

```http
PATCH /delete-soft?id=1
```

Soft delete means:
- Student is not removed from database
- `deleted = true`

Soft deleted students are hidden from:
- Get All Students
- Get Student By ID
- Update Student

---

# API Response Format

Success Response:

```json
{
  "message": "Student created successfully",
  "data": {
    "id": 1,
    "name": "Shivam Mishra",
    "age": 23,
    "email": "shivam@gmail.com",
    "rollNo": 101,
    "subject": "CSE",
    "deleted": false
  }
}
```

Error Response:

```json
{
  "message": "Student not found with id: 10"
}
```

---

## Database Configuration

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Installation & Setup

### Clone Repository

```bash
git clone https://github.com/your-username/CRUD_springboot.git
```

### Navigate to Project

```bash
cd CRUD_springboot
```

### Run Application

```bash
mvn spring-boot:run
```

---

## Future Improvements

- Global Exception Handling
- DTO Layer
- Validation using Bean Validation
- Swagger/OpenAPI
- JWT Authentication
- Docker Deployment

---

## Author

**Shivam Mishra**