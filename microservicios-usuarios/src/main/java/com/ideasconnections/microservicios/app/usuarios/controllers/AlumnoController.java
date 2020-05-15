package com.ideasconnections.microservicios.app.usuarios.controllers;


import com.ideasconnections.microservicios.app.usuarios.models.entity.Alumno;
import com.ideasconnections.microservicios.app.usuarios.services.AlumnoService;
import com.ideasconnections.microservicios.commons.controllers.CommonController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService>{


    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Alumno> optionalAlumno = service.findById(id);

        if (!optionalAlumno.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoDb = optionalAlumno.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }
}
