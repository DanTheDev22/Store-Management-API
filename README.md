# Sample REST CRUD API with Spring Boot, PostGreSQL, JPA and Hibernate 

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/DanTheDev22/Store-Management-API.git
```

**2. Create PostGreSQL database**
```bash
create database storedb
```

**3. Change postgreSql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your postgreSql installation

**4. Build and run the app using maven**

```bash
mvn clean install
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /{id}
    
    GET /get
    
    POST /save
    
    PUT /update/{id}
    
    DELETE /{id}
