## People API - Developed with Java and SpringBoot

This project was created with studies intention, during a live coding of DIO.

For start this project is necessary have the Java 11 and Maven 3.6.3 or more.

### For run this project:

> mvn spring-boot:run

### Endpoints:

GET:
> https://localhost:8080/api/v1/people/
for list all people persisted

GET:
> https://localhost:8080/api/v1/people/{id}
for return only a person by id

POST:
> https://localhost:8080/api/v1/people/
for create new person

DELETE:
> https://localhost:8080/api/v1/people/{id}
for delete a person by id

PUT:
> https://localhost:8080/api/v1/people/{id}
for updated a person by id. The request body should contains the id and all attributes modified and not modified.