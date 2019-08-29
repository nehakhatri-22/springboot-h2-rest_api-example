# Spring Boot REST API with H2 Database

A small example of a Spring Boot REST API with H2 for a database, demonstrating elementary CRUD operations in response to HTTP as well as returning JSON.
## Getting Started


### Installing
Make sure to edit your ```application.properties``` and change the database information to reflect where you would like H@ to create the DB file.
It is currently set to the directly from which you are compiling the application.
```sh
spring.datasource.url=jdbc:h2:file:./notesDB
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=berti
spring.datasource.password=
```
To test out this application, you need Maven to build the dependencies.

- First, install the dependencies

```sh
mvn clean install
```
- Second, run the production build with live reload
```sh
mvn spring-boot:run
```

End with an example of getting some data out of the system or using it for a little demo


## Built With


* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) - Quick start Spring Framework web applications
* [H2 Database Engine](https://h2database.com/) - the Java SQL database
* [JSON.simple](https://github.com/fangyidong/json-simple) -JSON.simple is a simple Java toolkit for JSON



## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
