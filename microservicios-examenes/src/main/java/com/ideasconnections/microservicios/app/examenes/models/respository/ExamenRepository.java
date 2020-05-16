package com.ideasconnections.microservicios.app.examenes.models.respository;



import org.springframework.data.repository.CrudRepository;

import com.ideasconnections.microservicios.commons.examenes.models.entity.Examen;

public interface ExamenRepository extends CrudRepository<Examen, Long> {
}
