# 🏟️ TurfHub

A full-stack sports turf booking platform built with **Flutter**, **Spring Boot**, and **MySQL**.

---

### ✨ Features
- **User Authentication**: Secure user registration and login.
- **Multi-City Discovery**: Browse turfs filtered by city (Pune, Mumbai, Nashik, Kolhapur, etc.).
- **Live Slot Booking**: View real-time slot availability and reserve slots instantly.
- **Double-Booking Protection**: Transactional slot locking prevents duplicate reservations.

---

### 🛠️ Tech Stack
- **Frontend**: Flutter (Android/iOS), Dart, Material 3
- **Backend**: Spring Boot 4, Java 25, Spring Data JPA, Hibernate
- **Database**: MySQL 8

---

### 📡 API Overview
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/users/register` | Register new user |
| `POST` | `/api/users/login` | Authenticate user |
| `GET` | `/api/turfs` | Fetch turfs |
| `GET` | `/api/slots/turf/{id}/available` | Fetch available slots for a turf |
| `POST` | `/api/bookings` | Book a time slot |
| `DELETE` | `/api/bookings/{id}` | Cancel a booking and free the slot |

---

### 🚀 Quick Start

#### 1. Backend (Spring Boot)
Ensure MySQL is running, then start the server:
```bash
cd backend
./mvnw spring-boot:run
```
> Server runs on `http://localhost:8080`.

#### 2. Mobile App (Flutter)
```bash
cd mobile
flutter pub get

# If testing on physical Android device over USB:
adb reverse tcp:8080 tcp:8080

flutter run
```

---

### 👤 Author
**Shreyas Gadekar**
- GitHub: [@ShreyasGadekar9](https://github.com/ShreyasGadekar9)
- Email: gadekarshreyas99@gmail.com
