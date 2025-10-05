# 📦 Inventory Management Service

A backend REST API to manage Warehouse Inventory.  
Built using **Spring Boot** and **MySQL**, this service enables full **CRUD operations on inventories**, along with **stock increase/decrease logic with stock quantity validation**.

---

## 🚀 Features

| Feature                | Description                                        |
|------------------------|----------------------------------------------------|
| Inventory Management   | Create, Read, Update, Delete inventories           |
| Manual ID Handling     | ID must be provided by client (no auto-generation) |
| Prevent Negative Stock | Stock cannot go below zero                         |
| Stock Operations       | `POST /{id}/increase` and `POST /{id}/decrease`    |
| Pure Entity-Based API  | Controller uses `inventory` entity directly        |

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
```

Create the database in MySQL if not exists:
```sql
CREATE DATABASE inventory_db;
```

---

## 📌 API Endpoints

### inventory CRUD

| Method | Endpoint                | Description                                     |
|--------|-------------------------|-------------------------------------------------|
| `POST` | `/inventory`            | Create inventory (ID must be provided manually) |
| `GET` | `/inventory`            | Get all inventories                             |
| `GET` | `/inventory/{id}`       | Get inventory by ID                             |
| `PUT` | `/inventory/{id}`   | Update inventory                                |
| `DELETE` | `/inventory/{id}` | Delete inventory                                |

**Example Create Request:**
```json
POST /inventory
{
  "id": 101,
  "name": "Keyboard",
  "description": "Wireless Keyboard",
  "stockQuantity": 10
}
```

### Stock Management

| Method | Endpoint | Body | Description |
|--------|----------|------|-------------|
| `POST` | `/inventory/{id}/increase` | `{ "amount": 5 }` | Increase stock |
| `POST` | `/inventory/{id}/decrease` | `{ "amount": 3 }` | Decrease stock (fails if below 0) |

### Error Example
```json
{
  "error": "Insufficient stock. Available: 2, Requested: 5"
}
```

---

## ▶️ Running the Application

```bash
mvn spring-boot:run
```

Or run the main class `InventoryApplication.java` from your IDE.

---

## 🧪 Testing

Currently, no automated test cases are included. You can test the API manually using **Postman** or **cURL** with the endpoints above.

---

## 💡 Assumptions & Design Choices

- **Manual ID Handling:** IDs are provided by clients for explicit control.
- **Entity-Based API:** No DTOs; controllers use `Product` entity directly for simplicity.
- **Stock Validation:** Stock cannot go below zero; attempts to decrease more than available return a `400 Bad Request`.
- **Transactional Stock Operations:** Ensures consistency when increasing or decreasing stock.

---

## 👩‍💻 Author

**Shivani Chawhan**  
GitHub: [https://github.com/ShivaniChawhan/InventoryMgmtService](https://github.com/ShivaniChawhan/InventoryMgmtService)