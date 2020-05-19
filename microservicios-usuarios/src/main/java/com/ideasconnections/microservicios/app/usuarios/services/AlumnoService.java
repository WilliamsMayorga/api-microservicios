package com.ideasconnections.microservicios.app.usuarios.services;

import java.util.List;

import com.ideasconnections.microservicios.commons.alumnos.models.entity.Alumno;
import com.ideasconnections.microservicios.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno> {
	public List<Alumno> findByNombreOrApellido(String term);

	public Iterable<Alumno> findAllById(Iterable<Long> ids);
}
