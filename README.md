# SpringBoot-Rest-JPA-Hibernate
Sample of CRUD application using Spring Boot + Restful API + JPA / Hibernate 

The original tutorial for this sample is available on [Youtube](https://www.youtube.com/watch?v=DCZOchCX10s) and  [author´s Git Hub](https://github.com/varuncbv/SpringBootRestAPIHibernateJPAMYSQLTutorial/), the sample in this repository has smaller changes to make it up to date with OracleXE, Hirakari Connection Pool 3.3.1 and Spring Boot 2.13.  Further explanation on JPA annotation present in this sample can be found on [Spring Guides](https://github.com/spring-guides/gs-accessing-data-jpa).  The [MKyound Spring Boot example](https://www.mkyong.com/spring-boot/spring-boot-spring-data-jpa-oracle-example/) also give more tips of the implementation. 

## Tools 

- [Eclipse IDE](https://www.eclipse.org/downloads/packages/)
- [Tomcat 9.0](https://tomcat.apache.org/download-90.cgi)
- [Postman](https://www.getpostman.com/downloads/)

## Snippets

###  Create Oracle User

```
create user exampledb identified by pwd123 default tablespace users quota unlimited ON users temporary tablespace temp;
grant connect, create session, imp_full_database to exampledb;
grant analyze any to exampledb;
GRANT DBA TO exampledb;
```

### Post Request to add a employee

- Options to choose on postman: POST / raw / JSON (application/json)

````
{
    "name": "Airton Senna",
    "designation": "Car Racing Driver",
    "expertise": "Wet road"
}
````



