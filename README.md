# Taco Cloud

**Taco Cloud** is a sample web application built using **Spring Boot** and **Spring MVC**. It demonstrates building a complete MVC-based web application with form validation, data
persistence, and security.

---

## Features

- Create and customize tacos using dynamic forms
- Persistent storage with Spring Data JPA and H2/MySQL
- Spring MVC controllers for clean routing and model handling
- Spring Security integration for login and user registration
- Thymeleaf templates for responsive UI rendering
- Validation for taco design and order forms
- RESTful API layer (optional) for external consumption

---

## Technologies Used

- Java 17+
- Spring Boot (Web, MVC, Security, JPA)
- Thymeleaf Template Engine
- Spring Data JPA / Hibernate
- H2 / MySQL Database
- Lombok 
- Maven

---

## Project Structure

src/ ■■ main/ ■ ■■ java/tacos/ ■ ■ ■■ TacoCloudApplication.java # Main Spring Boot app ■ ■ ■■ controller/ #
Web controllers ■ ■ ■■ data/ # Repository interfaces ■ ■ ■■ domain/ # Entities (Taco, Ingredient, Order, User)
■ ■ ■■ security/ # Spring Security configuration ■ ■■ resources/ ■ ■■ static/ # CSS, images ■ ■■ templates/ #
Thymeleaf HTML views ■ ■■ application.properties # App configuration ■■ test/ # Unit and integration tests

---

## Setup and Run

### 1. Clone the repository

```bash
git clone https://github.com/n-nykyforuk/taco-cloud.git
cd Notes
```

### 2. Configure the application


# Database
spring.datasource.url=jdbc:mysql://localhost:3306/taco_cloud?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# OAuth2 - Facebook
spring.security.oauth2.client.registration.facebook.client-id=<facebook client id>
spring.security.oauth2.client.registration.facebook.client-secret=<facebook client secret>
spring.security.oauth2.client.registration.facebook.scope=email,public_profile
spring.security.oauth2.client.provider.facebook.authorization-uri=https://www.facebook.com/dialog/oauth
spring.security.oauth2.client.provider.facebook.token-uri=https://graph.facebook.com/oauth/access_token
spring.security.oauth2.client.provider.facebook.user-info-uri=https://graph.facebook.com/me?fields=id,name,email,picture
spring.security.oauth2.client.provider.facebook.user-name-attribute=id

# Authorization Server config
spring.security.oauth2.client.registration.taco-admin-client.client-id=taco-admin-client
spring.security.oauth2.client.registration.taco-admin-client.client-secret=secret
spring.security.oauth2.client.registration.taco-admin-client.authorization-grant-type=authorization_code
spring.security.oauth2.client.registration.taco-admin-client.redirect-uri=http://127.0.0.1:9090/login/oauth2/code/taco-admin-client
spring.security.oauth2.client.registration.taco-admin-client.scope=openid,writeIngredients,deleteIngredients

spring.security.oauth2.client.provider.taco-admin-client.authorization-uri=http://localhost:9000/oauth2/authorize
spring.security.oauth2.client.provider.taco-admin-client.token-uri=http://localhost:9000/oauth2/token
spring.security.oauth2.client.provider.taco-admin-client.user-info-uri=http://localhost:9000/userinfo
spring.security.oauth2.client.provider.taco-admin-client.jwk-set-uri=http://localhost:9000/oauth2/jwks
spring.security.oauth2.client.provider.taco-admin-client.user-name-attribute=sub

#Config
taco.orders.pageSize=10

#Rest
spring.data.rest.base-path=/data-api

#Rabbit
spring.profiles.active=prod
spring.rabbitmq.host=rabbit.tacocloud.com
spring.rabbitmq.port=5673
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
spring.rabbitmq.template.exchange=tacocloud.order
spring.rabbitmq.template.routing-key=kitchens.central
spring.rabbitmq.template.receive-timeout = 20000

### 3. Build and run the backend
mvn clean install
mvn spring-boot:run
Once started, the backend will be available at:
http://localhost:8080

---

## Example Endpoints

- GET `/design` — Design your custom taco
- POST `/orders` — Submit an order
- GET `/login` — User authentication
- GET `/register` — Create a new user account

---

## Security

The project includes **Spring Security** for user authentication and authorization. Users must register and log in
before placing orders. Passwords are securely stored using BCrypt encoding. The configuration is located in
`security/` package.

---

##  Notes

This project serves as a practical learning example for understanding Spring Boot MVC, data validation, and
security fundamentals. You can extend it by adding a REST API layer, unit tests, or containerization with Docker

---

## Author
**Nazar Nykyforuk**
■ GitHub: https://github.com/n-nykyforuk

---

## License
This project is licensed under the **MIT License**.


