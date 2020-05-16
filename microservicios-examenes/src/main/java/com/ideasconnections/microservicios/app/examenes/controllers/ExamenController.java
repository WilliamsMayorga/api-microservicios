package com.ideasconnections.microservicios.app.examenes.controllers;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideasconnections.microservicios.app.examenes.services.ExamenService;
import com.ideasconnections.microservicios.commons.controllers.CommonController;
import com.ideasconnections.microservicios.commons.examenes.models.entity.Examen;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
		Optional<Examen> examenOptional = service.findById(id);
		if (!examenOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Examen examenDb = examenOptional.get();
		examenDb.setNombre(examen.getNombre());

		examenDb.getPreguntas().stream().filter(preguntaDb -> !examen.getPreguntas().contains(preguntaDb))
				.forEach(examenDb::removePregunta);

		examenDb.setPreguntas(examen.getPreguntas());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
	}
	
	@GetMapping("filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombre(term));
	}
}
