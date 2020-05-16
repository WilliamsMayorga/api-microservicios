package com.ideasconnections.microservicios.commons.alumnos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.ideasconnections.microservicios.commons.alumnos.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
