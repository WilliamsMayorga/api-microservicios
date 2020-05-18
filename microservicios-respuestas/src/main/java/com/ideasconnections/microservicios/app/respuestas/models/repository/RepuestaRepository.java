package com.ideasconnections.microservicios.app.respuestas.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.ideasconnections.microservicios.app.respuestas.models.entity.Respuesta;

public interface RepuestaRepository extends CrudRepository<Respuesta, Long> {

}
