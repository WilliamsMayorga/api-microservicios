package com.ideasconnections.microservicios.app.usuarios.controllers;


import com.ideasconnections.microservicios.app.usuarios.models.entity.Alumno;
import com.ideasconnections.microservicios.app.usuarios.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        //htpp status 200
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<Alumno> optionalAlumno = service.findById(id);
        if (!optionalAlumno.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalAlumno.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
        Alumno alumnoDb = service.save(alumno);
        //htpp status 201
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Alumno> optionalAlumno = service.findById(id);

        if (!optionalAlumno.isPresent()) {
            //htpp status 404
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoDb = optionalAlumno.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());
        //htpp status 201
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        //htpp status 204
        return ResponseEntity.noContent().build();
    }
}
