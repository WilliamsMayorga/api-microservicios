package com.ideasconnections.microservicios.app.examenes.services;

import java.util.List;

import com.ideasconnections.microservicios.commons.examenes.models.entity.Asignatura;
import com.ideasconnections.microservicios.commons.examenes.models.entity.Examen;
import com.ideasconnections.microservicios.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen>{
	public List<Examen> findByNombre(String term);
	
	public Iterable<Asignatura> findAllAsignaturas();

}
