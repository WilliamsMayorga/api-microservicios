package com.ideasconnections.microservicios.app.respuestas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideasconnections.microservicios.app.respuestas.models.entity.Respuesta;
import com.ideasconnections.microservicios.app.respuestas.services.RespuestaService;

@RestController
public class RespuestaController {
	@Autowired
	private RespuestaService service;

	@PostMapping()
	public ResponseEntity<?> crear(@RequestBody Iterable<Respuesta> respuestas) {
		Iterable<Respuesta> respuestasDb = service.savaAll(respuestas);
		return ResponseEntity.status(HttpStatus.CREATED).body(respuestasDb);
	}
}
