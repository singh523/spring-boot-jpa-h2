# Spring-boot-data-H2-embedded

This Demo App uses Spring Boot Data with H2 In Memory Database

Basic database operations using Spring Data explained with simple examples

Create a Spring Boot application using https://start.spring.io (Spring Initializer) by chosing dependencies as Spring Web & Data

In this app we used H2 in memory database for demo purpose. 

application.yml

```
spring:
  datasource:
    url: jdbc:h2:~/test
    driver-class-name: org.h2.Driver
    username: sa
    password:
    platform: h2
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    show-sql: true
  h2:
    console:
      enabled: true
```

This single line will do all the magic for you using Spring JPA

```
public interface UserRepository extends JpaRepository<Employee, Long>{
}
```

To download this code

git clone https://github.com/singh523/spring-boot-jpa-h2.git
