# 🛒 E-commerce Site Backend – Test and CI/CD-Focused Project

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED?style=for-the-badge&logo=docker)
![Jenkins](https://img.shields.io/badge/Jenkins-CI%2FCD-D24939?style=for-the-badge&logo=jenkins)
![Tests](https://img.shields.io/badge/Tests-100%25_Passing-brightgreen?style=for-the-badge)


This project is an e-commerce site backend application developed using Spring Boot,
featuring a multi-tier architecture,
with a focus on testing and automated CI/CD processes.

The goal is not only to develop a functional system,
but also to create a sustainable and professional backend architecture
that has been validated through unit, integration, and system/API tests,
and is supported by Docker and Jenkins.

---

## 🎯 Project Objectives

- Develop a realistic e-commerce site backend architecture
- Implement software testing levels (Unit / Integration / System)
- Set up an automated CI/CD process using Jenkins
- Run the application entirely on Docker containers
- Establish a structure that automatically reports test results

---

## 🏗️ Architectural Structure

The project was developed using a N-Tier Architecture approach.

### Layers

| Layer | Description |
|------|---------|
| API (Controller) | Handles HTTP requests |
| Business (Service) | Business rules and validations |
| DataAccess (Repository) | Database operations |
| Entities | Domain models |
| Tests | Unit, Integration, and System/API tests |

---

## 🔄 Testing Approach

### 🧪 Unit Tests
- Tests the business rules in the Business layer
- Mock objects were used with Mockito

### 🔗 Integration Tests
- Tests cross-layer interactions
- Runs with a real Spring Context

### 🌐 System / API Tests
- Validates end-to-end scenarios
- API tests are performed on the live system

---

## 📊 Automated Test Results

<img width="1568" height="463" alt="Screenshot 2026-01-25 183812" src="https://github.com/user-attachments/assets/e7e0c822-b800-44ef-a252-e0474051abea" />


- 🧪 Unit Tests: 5 / 5 ✅
- 🔗 Integration Tests: 3 / 3 ✅
- 🌐 System / API Tests: 3 / 3 ✅
- ⏱️ Total test duration: ~35 seconds
- ❌ Error rate: 0%

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- JUnit
- Mockito
- Docker
- Docker Compose
- Jenkins
- Swagger (OpenAPI)

---

## ⚙️ CI/CD Process

The following steps run automatically with every push:

1. Code is pulled from the repo
2. The project is built
3. Unit tests are run
4. Integration tests are run
5. Docker containers are spun up
6. API tests are performed on the running system

---

## 🐳 Using Docker

- Environment dependencies are isolated
- No need to install Java or Maven on your local machine
- Fully compatible with CI/CD processes

---

## ▶️ Running the Application

### Requirements

- Docker
- Docker Compose
- Git

---

### 1️⃣ Clone the Project

```bash
git clone https://github.com/fatmagul-yilmaz/ecommerce-backend-ci-cd.git
cd ecommerce-backend-ci-cd
```

---

### 2️⃣ Start the Containers

```bash
docker-compose up --build
```

The application is built and the necessary services are started.

---

### 3️⃣ Test the API with Swagger

```text
http://localhost:8084/swagger-ui/index.html
```

---

### 4️⃣ Run Tests Manually

```bash
docker-compose run app mvn test
```

---

### 5️⃣ Stop the Containers

```bash
docker-compose down
```


### 👩‍💻 Developer

**Fatmagül Yılmaz**
