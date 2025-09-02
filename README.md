# Project Description

This application is built using **Java Spring Boot**.  
It is configured to run with **Java 17** and **Maven** as the build tool.

Currently, the application uses **HashMap** as an in-memory data store.  
Although **Hibernate** and a local SQL database could be added for persistence, in this version the data is not stored permanently in the system.  
That’s why a **HashMap** is used to temporarily store the data during runtime.

## How to Run

1. Make sure you have **Java 17** installed.
2. Open the project in **IntelliJ IDEA** (or any IDE of your choice).

## Once the application is running, open your browser and go to:

   👉 [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

This will open the **Swagger UI**, where you can test all the REST APIs interactively.
