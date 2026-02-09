# Employee Service

A Spring Boot RESTful microservice for managing employees, built with **Spring Boot**, **MySQL**, and **Docker**.  
The application allows you to create and fetch employee records and is fully containerized using **Docker Compose**.

---

##  Features

- Create employee records
- Fetch all employees
- REST APIs using Spring Boot
- MySQL as the data store
- Dockerized application
- Docker Compose for multi-container setup (App + MySQL)
- Persistent MySQL storage using Docker volumes

---

##  Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data MySQL**
- **MySQL**
- **Maven**
- **Docker & Docker Compose**


## Setup and running the application

Follow below steps to clone and run the application in local :

1. git clone https://github.com/mosama-nagarro/employee-service
2. cd employee-service
3. docker build -t employee-service:1.0 .
4. docker compose up
5. Go to http://localhost:8080/index.html

