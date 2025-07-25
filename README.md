# 📚 Library Loan API - Spring Boot

Esta es una API REST desarrollada en **Spring Boot** para gestionar préstamos de libros. Permite registrar libros y usuarios, 
realizar préstamos y devoluciones de libros. Es una prueba técnica para la posición de **Trainee Java Developer**.

---

## 🚀 Tecnologías Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Maven
- Lombok
- Spring Validation

---

## 🧩 Estructura del Proyecto

- `controller/` → Exposición de endpoints
- `service/` → Lógica de negocio
- `repository/` → Persistencia con JPA
- `model/` → Entidades de base de datos
- `dto/` → Clases para transferencia de datos
- `mapper/` → Conversores entre entidades y DTOs

---

### Inicializar el Servidor

### Requisitos Previos

Asegúrate de tener instalado lo siguiente en tu máquina:

- ✅ Java 21 
- ✅ Maven 3.8 o superior
- ✅ MySQL en ejecución
- ✅ Un IDE o editor de texto (IntelliJ, VSCode, etc.)

---

### Crear la Base de Datos en MySQL

Primero, debes crear manualmente la base de datos en MySQL:

### Configuraciones básica de application.yml
```yaml
server:
  port: 8080
  servlet:
    context-path: /api/v1

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/nombre_de_la_bd
    username: nombre_de_usuario
    password: contraseña
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
```

```sql
CREATE DATABASE prestamos_libros_db;
```

### Ejecutar

```bash
mvn spring-boot:run
```

## ✅ Funcionalidades

### 📘 Libros

- Registrar un libro (`POST /api/v1/books`)
- Cada libro tiene: `title`, `author`, `isbn`, `available`

### 👤 Usuarios

- Registrar un usuario (`POST /api/v1/users`)
- Cada usuario tiene: `name`, `lastName`, `dni`

### 🔁 Préstamos

- Prestar libros (`POST /api/v1/loans`)
    - Solo si están disponibles
    - Cambia su estado a `available = false`
- Devolver un préstamo (`PUT /loans/{loanId}/return`)
    - Libros vuelven a `available = true`

---

## 📦 Endpoints

### Registrar libro

**POST** `/api/v1/users`

```json
{
  "name": "Juan",
  "last_name": "Pérez",
  "dni": "12345678902"
}
```

### Crear libro

**POST** `/api/v1/books`

```json
{
  "tittle": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "available": true
}
```

### Realizar préstamos

**POST** `/api/v1/loans`

```json
{
  "user_id": 1,
  "books_ids": [1,3]
}
```

### Devolver libro

**POST** `/api/v1/loans/{bookId}/return`
