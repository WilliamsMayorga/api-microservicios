# API MICROSERVICIOS SPRING CLOUD
Gestionar los examanes de los estudiantes de una determinada instituto

### Herramientas y Entorno
+ Java 8
+ Maven 3.x
+ PostgreSQL
+ MySQL
+ MongoDB

## Microservicios cursos
### Dependencias :
Estas Dependencias son agregadas para implementacion del microservicio
+ Spring Boot Dev Tools
+ Spring Data JPA
+ MySQL Driver
+ Spring Web

## Microservicios Eureka
Es un microservicio que se comporta como servidor, cuyo objetivo es registrar y localizar microservicios existentes, 
informar de su localización, su estado y datos relevantes de cada uno de ellos.

El servidor Eureka mantendrá la información de todos los microservicios registrados y su estado. Cada microservicio
 le notificará su estado mediante *heartbeats* cada 30 segundos.

 Si pasados tres periodos heartbeats no recibe ninguna notificación del microservicio, lo eliminará de su registro.

 Proyecto Netflix OSS (Open Source Software) para aplicaciones Spring Boot

### Dependencias :
+ Eureka Server

### Configuraciones :
+ Maven dependencias
    ```xml
        <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
    ```
+ Aplicación principal, incluimos las dependencias de *@EnableEurekaServer*
    ```java
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

        @EnableEurekaServer
        @SpringBootApplication
        public class MicroserviciosEurekaApplication {

            public static void main(String[] args) {
                SpringApplication.run(MicroserviciosEurekaApplication.class, args);
            }

        }
    ```
+ Configuración del puerto y nombre del servidor:
    ```properties
        #nombre del servidor
        spring.application.name = microservicio-eureka-server
        #puerto
        server.port = 8761

        #clientes
        eureka.client.register-with-eureka = false
        eureka.client.fetch-registry = false
    ```

## Microservicios Examenes
### Dependencias :
+ Spring Boot Dev Tools
+ Spring Data JPA
+ Eureka Discovery Client
+ MySQL Driver
+ Spring Web

## Microservicios gatewary
### Dependencias :
+ Spring Boot Dev Tools
+ Gateway
+ Eureka Discovery Client

## Microservicios Respuestas
### Dependencias :
+ Spring Boot Dev Tools
+ Spring Data MongoDB
+ Eureka Discovery Client
+ OpenFeing
+ Spring Web

## Microservicios Usuarios
### Dependencias :
+ Spring Boot Dev Tools
+ PostgreSQL Driver
+ Eureka Discovery Client
+ OpenFeing
+ Spring Web

## Microservicios Zuul

Zuul es un “edge service” que permite enrutado dinámico, balanceo de carga, monitorización y securización de peticiones. 
A efectos prácticos Zuul es un servidor compuesto por filtros, cada uno de los cuales está enfocado a una funcionalidad

### Dependencias :
+ Spring Boot Dev Tools
+ Eureka Discovery Client
+ Zuul
+ Spring Web

### Configuraciones
+ Maven dependencias, las dos dependencias importantes es la dependecia zuul y ser cliente eureka
    ```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        </dependency>
    ```
+ Aplicación principal, incluimos las dependencias de *@EnableEurekaServer*
    ```java
        package com.ideasconnections.microservicios.app.zuul;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
        import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

        @EnableZuulProxy
        @EnableEurekaClient
        @SpringBootApplication
        public class MicroserviciosZuulApplication {

            public static void main(String[] args) {
                SpringApplication.run(MicroserviciosZuulApplication.class, args);
            }

        }
    ```
+ Configuración del puerto y nombre del servidor:
    ```properties
        spring.application.name = microservicio-zuul
        server.port = 8090

        eureka.client.service-url.defaulZone = http://localhost:8761/eureka

        zuul.routes.usuarios.service-id=microservicio-usuarios
        zuul.routes.usuarios.path=/api/alumnos/**

        zuul.routes.cursos.service-id=microservicio-cursos
        zuul.routes.cursos.path=/api/cursos/**

        zuul.routes.examenes.service-id=microservicio-examenes
        zuul.routes.examenes.path=/api/examenes/**

        zuul.routes.respuestas.service-id=microservicio-respuestas
        zuul.routes.respuestas.path=/api/respuestas/**
    ```