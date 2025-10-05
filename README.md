# 📦 Inventory Management Service

A backend REST API to manage Inventory.  
Built using **Spring Boot** and **MySQL**, this service enables full **CRUD operations on Inventory**, along with **stock increase/decrease logic with stock quantity validation**.

---

## 🚀 Features

| Feature                | Description                                        |
|------------------------|----------------------------------------------------|
| Inventory Management   | Create, Read, Update, Delete Inventory             |
| Manual ID Handling     | ID must be provided by client (no auto-generation) |
| Prevent Negative Stock | Stock cannot go below zero                         |
| Stock Operations       | `POST /{id}/increase` and `POST /{id}/decrease`    |
| Pure Entity-Based API  | Controller uses `Inventory` entity directly        |

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**

---

## 📂 Database Configuration

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
