# How to make things work

### Build Spring-boot project

```bash
mvn clean install -DskipTests=true
```

### Getting network address of docker
```bash
inspect -f '{{ .NetworkSettings.Gateway }}'
```
### Starting Postgres on docker
 ```docker 
 docker run --name oms_postgres -p 5432:5432 -e POSTGRES_USER=dbuser -e POSTGRES_DB=dbname -e POSTGRES_PASSWORD=password -d postgres
 ```
### Application.properties.template
```
spring.datasource.url=jdbc:postgresql://[network-address]:5432/products_db
spring.datasource.username=dbuser
spring.datasource.password=password
spring.jpa.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

### Inside dockerFile
```docker
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/app.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080
```

### Start server
```docker
docker build .
docker run -p 8080:8080 [image-id]
```
