# CRUD Spring Boot API

A simple CRUD REST API built using **Spring Boot**, **Spring Data JPA**, and **MySQL** for managing student records.

## Features

- Create Student
- Get All Students
- Get Student By ID
- Update Student
- Delete Student
- Global Exception Handling
- Custom API Response Structure
- Swagger UI Documentation

---

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Swagger UI (OpenAPI)

---

## Project Structure

```bash
src/main/java/com/springboot/CRUD_springboot
│
├── controller
├── service
├── repository
├── entity
├── utilities
└── ApiResponse
```

---

## API Base URL

```bash
http://localhost:8080/api/v1
```

---

## Endpoints

### Create Student

```http
POST /students
```

Sample Request:

```json
{
  "id": 1,
  "name": "Shivam Mishra",
  "age": 23,
  "email": "shivam@gmail.com",
  "rollNo": 101,
  "subject": "Computer Science"
}
```

---

### Get All Students

```http
GET /students
```

---

### Get Student By ID

```http
GET /students/{id}
```

Example:

```http
GET /students/1
```

---

### Update Student

```http
PUT /students/{id}
```

Sample Request:

```json
{
  "name": "Updated Name",
  "age": 24,
  "email": "updated@gmail.com",
  "rollNo": 102,
  "subject": "Mathematics"
}
```

---

### Delete Student

```http
DELETE /students/{id}
```

---

## API Response Format

Success Response:

```json
{
  "message": "Student fetched successfully",
  "data": {
    "id": 1,
    "name": "Shivam Mishra"
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

## Swagger UI Documentation

Access API documentation here:

```bash
http://localhost:8080/api/v1/swagger-ui/index.html
```

---

## Database Configuration

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
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

- Validation using Bean Validation
- JWT Authentication
- Unit Testing
- Docker Deployment

---

## Author

**Shivam Mishra**
