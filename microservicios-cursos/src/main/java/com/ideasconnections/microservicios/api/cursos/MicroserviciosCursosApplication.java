package com.ideasconnections.microservicios.api.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.ideasconnections.microservicios.commons.alumnos.models.entity",
		"com.ideasconnections.microservicios.api.cursos.models.entity",
		"com.ideasconnections.microservicios.commons.examenes.models.entity" })
public class MicroserviciosCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCursosApplication.class, args);
	}

}
