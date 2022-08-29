# **🚕Taxi-Service🚕**

![vector-flat-taxi-logo-isolated-white-background-car-face-icon-silhouette-auto-template-service-brand-design-78247442](https://user-images.githubusercontent.com/96648890/187201983-00693691-b879-44e3-b390-95681072ac30.jpg)

<!-- ABOUT THE PROJECT -->
## **📢Project Description:**

This is a web application which simulates work of taxi service. It contents with backend and frontend parts.
The main purpose of this application is to keep records of taxi service drivers and cars. 
Non-authorized users are able to:

- login to the service with existing crendtials
- register a new account

so firstly you have to register yourself as a taxi driver:


![register](https://user-images.githubusercontent.com/96648890/187210818-849c811c-0b45-4dd7-8f16-4037528e5af3.jpg)


**After registration you must to login:**


![login](https://user-images.githubusercontent.com/96648890/187211387-a32703bc-ebd6-4e5e-924e-b07e588afabc.jpg)

**After logging in to the user authentication system, the following functionality is available to him:**

- Add car, driver or manufacturer
- Display car, driver or manufacturer
- Delete car, driver or manufacturer
- Add driver to car
- Display all drivers for current car
- Open the list of cars you can drive

![welcome](https://user-images.githubusercontent.com/96648890/187212182-70c8ee70-f49c-4081-beff-b27594e398f9.jpg)


## 💻Implementation details

Project based on 3-layer architecture:

- Presentation layer (controllers)
- Application layer (services)
- Data access layer (DAO)

## ⚡How run this project

This manual describes main steps for application running. To run this project you will need to install and set up following components:

- JDK 11 or higher
- Apache Maven
- Apache Tomcat (required: 9.0.50)
- MySQL

1. Clone this project to your IDE as Maven project.
2. Check a pom.xml file if any errors are occurred - fix them.
3. Configure Apache Tomcat and MySQL.
4. Add new Tomcat Server configuration and select war-exploded artifact to deploy. Set application context parameter to "/".
5. Create tables. Open MySql. Create SQL query and copy all from init_db.sql
6. Initialize database. It can be local or remote database.
7. In the package util, open a ConnectioUtil class and set there your credentials instead of dummies for DB connection.

  ````private static final String URL = "jdbc:mysql://<URL_TO_DATABASE>:<PORT>/<DATABASE_NAME>?serverTimezone=UTC";
      private static final String USERNAME = "<DATABASE_USERNAME>";
      private static final String PASSWORD = "<DATABASE_PASSWORD>";
      private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   ````  
  where:
- <URL_TO_DATABASE> - URL to Database (for local database: localhost)
- <PORT> - port number of database (for local database: 8080)
- <DATABASE_NAME> - name of database(for local database: taxi-service)
- <DATABASE_USERNAME> - username to get permission to read and write to database
- <DATABASE_PASSWORD - password for <DATABASE_USERNAME> user

8. Start Tomcat.

## 🔥Application technologies used

- JDK 11
- Maven
- MySQL 8.0.28
- JDBC
- HTML, CSS
- Java Servlet API 4.0.1
- Tomcat 9.0.50
- JSTL 1.2
- Junit jupiter api 5.9.0
- Log4j logging apache 2.18.0

## 📊Diagram of DB tables relations

![car_diagram_db_2_4f50942103](https://user-images.githubusercontent.com/96648890/187218716-d334aa4d-a8b2-4154-9057-5d8ef5ef44b8.png)
