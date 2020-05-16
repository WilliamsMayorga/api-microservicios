package com.ideasconnections.microservicios.app.examenes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ideasconnections.microservicios.app.examenes.models.entity.Examen;
import com.ideasconnections.microservicios.app.examenes.models.entity.Pregunta;
import com.ideasconnections.microservicios.app.examenes.services.ExamenService;
import com.ideasconnections.microservicios.commons.controllers.CommonController;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @RequestParam Long id) {
		Optional<Examen> examenOptional = service.findById(id);
		if(!examenOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Examen examenDb = examenOptional.get();
		examenDb.setNombre(examen.getNombre());
		
		List<Pregunta> eliminadas = new ArrayList<>();
		
		examenDb.getPreguntas().forEach(preguntaDb -> {
			if(!examen.getPreguntas().contains(preguntaDb)) {
				eliminadas.add(preguntaDb);
			}
		});
		
		eliminadas.forEach(pregunta -> {
			examenDb.removePregunta(pregunta);
		});
		
		examenDb.setPreguntas(examen.getPreguntas());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
	}
}
