# MyApp - Expense Management System

A Spring Boot application for managing expenses and financial accounts, developed remotely on a self-hosted production environment.

## 🚀 Development Environment

**⚠️ IMPORTANT:** This application is being **developed remotely on a self-hosted production environment** running **Debian GNU/Linux** as part of a webserver creation project. This is an active development setup on production infrastructure.

- **OS:** Debian GNU/Linux 13 (trixie)
- **Java:** OpenJDK 21
- **Build Tool:** Maven 3.x
- **Server:** Apache Tomcat (embedded in Spring Boot)
- **Development Approach:** Remote development on self-hosted infrastructure

## 📋 Project Overview

MyApp is an expense tracking application built with Spring Boot and PostgreSQL. It allows users to manage financial accounts and track expenses with categories.

### Features
- Account management with multiple account types
- Expense tracking with categorization
- Card management
- RESTful API endpoints
- PostgreSQL database integration
- Lazy loading for optimized queries

## 🏗️ Architecture

### Models
- **Account**: Represents a financial account (bank account, credit card, etc.)
- **Expense**: Tracks individual expenses linked to an account
- **Card**: Manages payment cards
- **Category**: Enumeration for expense categorization (FOOD, TRANSPORT, ENTERTAINMENT, UTILITIES, HEALTH, SHOPPING, OTHER)

### Database
- **Database**: PostgreSQL
- **Connection**: `jdbc:postgresql://localhost:5432/testdb`
- **DDL Auto**: Update (auto-creates/updates schema based on entities)

### API Endpoints
- `GET /api/cards` - Retrieve all cards
- `GET /api/expenses` - Retrieve all expenses

## 🛠️ Setup & Installation

### Prerequisites
- Java 21+
- Maven 3.x
- PostgreSQL 12+
- Debian-based Linux system

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd myapp
   ```

2. **Configure database** (update `application.properties` or `.env`)
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
   spring.datasource.username=postgres
   spring.datasource.password=1234
   ```

3. **Build the application**
   ```bash
   ./mvnw clean package
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

   Or with custom JVM settings:
   ```bash
   export MAVEN_OPTS="-Xmx512m -Xms256m"
   ./mvnw spring-boot:run
   ```

5. **Access the application**
   - Server runs on: `http://localhost:8081`

## ⚙️ Configuration

### Application Properties
- **Port**: 8081
- **Show SQL**: Enabled (SQL queries logged to console)
- **Hibernate DDL**: `update` (auto-manages schema)
- **Logging Level**: TRACE for Hibernate JDBC binding

### Environment Variables (`.env`)
Create a `.env` file in the project root:
```
SPRING_APPLICATION_NAME=myapp
SERVER_PORT=8081
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/testdb
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=1234
```

## 🔧 Development Notes

### Known Configuration
- **JVM**: OpenJDK 21 (with compiler level release flag)
- **Memory Constraints**: Limited system memory (3GB) - may require heap adjustments
- **Lazy Loading**: Account relationships use `FetchType.LAZY` to avoid serialization issues
- **JSON Serialization**: Account objects are excluded from JSON responses using `@JsonIgnore`

### Database Schema Auto-Creation
The application automatically creates and updates the database schema. Key features:
- Auto-generates primary keys (IDENTITY strategy)
- Creates relationships between entities
- Updates schema on application startup

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/yassin/myapp/
│   │   ├── MyappApplication.java
│   │   ├── controller/
│   │   │   ├── TaskController.java
│   │   │   └── ExpenseController.java
│   │   ├── model/
│   │   │   ├── Account.java
│   │   │   ├── Card.java
│   │   │   ├── Expense.java
│   │   │   ├── Category.java
│   │   │   └── AccountType.java
│   │   └── repository/
│   │       ├── AccountRepository.java
│   │       ├── CardRepository.java
│   │       └── ExpenseRepository.java
│   └── resources/
│       ├── application.properties
│       └── static/
└── test/
    └── java/com/yassin/myapp/
        └── MyappApplicationTests.java
```

## 🐛 Troubleshooting

### JVM Crash (Exit Code 134)
If the application crashes with SIGSEGV errors on low-memory systems:
```bash
export MAVEN_OPTS="-Xmx512m -Xms256m"
./mvnw spring-boot:run
```

### Database Connection Issues
Ensure PostgreSQL is running:
```bash
sudo systemctl status postgresql
```

### Lazy Loading Serialization Errors
The `@JsonIgnore` annotation prevents Jackson from serializing lazy-loaded relationships. If you need account information in API responses, consider using DTOs (Data Transfer Objects).

## 📝 Notes

- **Remote Development**: This project is actively developed on a remote, self-hosted Debian production server
- **Production Environment**: Development occurs directly on production infrastructure as part of webserver creation project
- **Git Ignored**: The `.env` file is in `.gitignore` to protect sensitive credentials
- **Active Development**: Features and bug fixes are continuously being deployed

## 📦 Dependencies

Key dependencies managed by Maven:
- Spring Boot 3.5.9
- Spring Web
- Spring Data JPA
- Jakarta Persistence API
- PostgreSQL JDBC Driver
- Jackson (JSON processing)
- Tomcat Embedded

## 🔐 Security Notes

- Database credentials stored in `.env` (not in version control)
- Password logging disabled in production
- Default DDL mode set to `update` for development (should be `validate` in production)

## 📞 Support

For issues or questions about this development setup, contact the project maintainer.

---

**Last Updated:** December 23, 2025  
**Status:** Active Development  
**Environment:** Self-hosted Debian Production Server  
**Webserver Project:** Part of custom webserver creation infrastructure
