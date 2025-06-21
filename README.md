# 🚆 Railway Reservation System - Spring Boot Project

A full-stack railway ticket reservation system built with Spring Boot, Thymeleaf, PostgreSQL, Bootstrap.

## 🌟 Features
- 🔐 User Registration & Login (Spring Security)
- 📅 View available trains & book seats
- 🎟️ My Bookings page with booking history
- 🛠 Admin dashboard to manage trains
- ✅ Bootstrap responsive design

## 💻 Tech Stack
- Java 17, Spring Boot 3
- Spring Security, Spring Data JPA
- PostgreSQL
- Thymeleaf
- Bootstrap 5

## ⚙️ Run Locally
1. Clone this repo
2. Import as Maven Project in Spring Tool Suite (STS)
3. Configure `application.properties` with your PostgreSQL DB:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/railwaydb
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword
