package com.ideasconnections.microservicios.app.examenes.models.respository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ideasconnections.microservicios.commons.examenes.models.entity.Examen;

public interface ExamenRepository extends PagingAndSortingRepository<Examen, Long> {
	@Query("select e from Examen e where e.nombre like %?1%")
	public List<Examen> findByNombre(String term);
}
