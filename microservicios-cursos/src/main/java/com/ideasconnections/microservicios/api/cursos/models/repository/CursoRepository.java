package com.ideasconnections.microservicios.api.cursos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.ideasconnections.microservicios.api.cursos.models.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {

}
