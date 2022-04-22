### Teste Codebrain Backend
This is a simple sales API in Java.

here's how to run a Spring Boot Application

## Building the Project with Maven
To be able to run the app you will need to first build it. To build and package the demo into a single executable Jar file with a Maven, use the below command. You will need to run it from the project folder which contains the pom.xml file.

```maven package```

or you can also use

```mvn install```

## Run app with java -jar command
To run the app from a command line in a Terminal window you can you the java -jar command. This is provided it was packaged as an executable jar file.

```java -jar target/teste.jar```

## Run app using Maven
You can also use Maven plugin to run the app. Use the below example to run the app with Maven plugin:

```mvn spring-boot:run```

## Run Spring Boot App with Gradle
And if you use Gradle you can run the app with the following command:

```gradle bootRun```

> [source](https://www.appsdeveloperblog.com/run-spring-boot-app-from-a-command-line/)

# Application address
The procedure above will serve the application at http://localhost:8080

## Changing the port
In order to change the port, in case the port 8080 is already in use, you have to change the server.port property at application.properties file
which is located at /src/main/resources

Example:

```
spring.application.name=teste
server.port=8081
```

will serve the application at http://localhost:8081

## API Documentation
Once the project is run, API documentation should be under http://localhost:8080/swagger-ui.html

# API Call Examples
## Create Product

POST localhost:8080/produto/
```
{
  "id": 1,
  "nome": "Produto",
  "preco": 10.0
}
```

## Update Product
POST localhost:8080/produto/1
```
{
  "id": 1,
  "nome": "Prod",
  "preco": 5.0
}
```

## Delete Product
DELETE localhost:8080/produto/1

## List Seller by Sales Quantity
GET localhost:8080/ranking/quantidadeVenda

## Create Sale
POST localhost:8080/venda/
```
{
  "id": 0,
  "produtos": [
    {
      "id": 1
    }
  ],
  "valorTotal": 100,
  "vendedor": {
    "matricula": 1
  }
}
```

## Create Seller
POST localhost:8080/vendedor/
```
{
  "matricula": 1,
  "nome": "João"
}
```

## Get Seller
GET localhost:8080/vendedor/1

## Update Seller
PUT localhost:8080/vendedor/1
```
{
  "matricula": 1,
  "nome": "Pedro"
}
```

## Delete Seller
DELETE localhost:8080/vendedor/1
