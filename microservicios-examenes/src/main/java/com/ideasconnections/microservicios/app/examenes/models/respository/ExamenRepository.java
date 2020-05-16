package com.ideasconnections.microservicios.app.examenes.models.respository;



import com.ideasconnections.microservicios.app.examenes.models.entity.Examen;
import org.springframework.data.repository.CrudRepository;

public interface ExamenRepository extends CrudRepository<Examen, Long> {
}
