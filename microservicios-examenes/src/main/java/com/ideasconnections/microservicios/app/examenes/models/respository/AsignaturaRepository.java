package com.ideasconnections.microservicios.app.examenes.models.respository;

import org.springframework.data.repository.CrudRepository;

import com.ideasconnections.microservicios.commons.examenes.models.entity.Asignatura;

public interface AsignaturaRepository extends CrudRepository<Asignatura, Long> {

}
