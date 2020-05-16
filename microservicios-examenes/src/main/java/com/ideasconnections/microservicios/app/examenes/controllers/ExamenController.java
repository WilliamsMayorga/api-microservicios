package com.ideasconnections.microservicios.app.examenes.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ideasconnections.microservicios.app.examenes.models.entity.Examen;
import com.ideasconnections.microservicios.app.examenes.services.ExamenService;
import com.ideasconnections.microservicios.commons.controllers.CommonController;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @RequestParam Long id) {
		return null;
	}
}
