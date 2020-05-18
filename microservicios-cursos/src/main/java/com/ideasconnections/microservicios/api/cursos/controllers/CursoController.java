package com.ideasconnections.microservicios.api.cursos.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideasconnections.microservicios.api.cursos.models.entity.Curso;
import com.ideasconnections.microservicios.api.cursos.services.CursoService;
import com.ideasconnections.microservicios.commons.alumnos.models.entity.Alumno;
import com.ideasconnections.microservicios.commons.controllers.CommonController;
import com.ideasconnections.microservicios.commons.examenes.models.entity.Examen;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Curso> cursoOptional = this.service.findById(id);
		if (!cursoOptional.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursoDb = cursoOptional.get();
		cursoDb.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
	}

	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id) {
		Optional<Curso> optionalCurso = this.service.findById(id);
		if (!optionalCurso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = optionalCurso.get();
		alumnos.forEach(alumno -> {
			cursoDb.addAlumno(alumno);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));

	}

	@DeleteMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
		Optional<Curso> optionalCurso = this.service.findById(id);
		if (!optionalCurso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = optionalCurso.get();
		cursoDb.removeAlumno(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));

	}

	@GetMapping("alumno/{id}")
	public ResponseEntity<?> buscarPorAlumnoId(@PathVariable Long id) {
		Curso cursoDb = service.findCursoByAlumnoId(id);

		if (cursoDb != null) {
			List<Long> examenesIds = (List<Long>) service.obtenerExamenesIdsConRespuestasAlumno(id);
			List<Examen> examenes = cursoDb.getExamenes().stream().map(examen -> {
				if (examenesIds.contains(examen.getId())) {
					examen.setRespondido(true);
				}
				return examen;
			}).collect(Collectors.toList());
			cursoDb.setExamenes(examenes);
		}
		return ResponseEntity.ok(cursoDb);
	}

	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id) {
		Optional<Curso> optionalCurso = this.service.findById(id);
		if (!optionalCurso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = optionalCurso.get();
		examenes.forEach(examen -> {
			cursoDb.addExamen(examen);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));

	}

	@DeleteMapping("/{id}/eliminar-examen")
	public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen, @PathVariable Long id) {
		Optional<Curso> optionalCurso = this.service.findById(id);
		if (!optionalCurso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = optionalCurso.get();
		cursoDb.removeExamen(examen);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));

	}

}
