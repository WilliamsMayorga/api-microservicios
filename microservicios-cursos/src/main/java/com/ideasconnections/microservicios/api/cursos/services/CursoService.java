package com.ideasconnections.microservicios.api.cursos.services;

import com.ideasconnections.microservicios.api.cursos.models.entity.Curso;
import com.ideasconnections.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso>{
	public Curso findCursoByAlumnoId(Long id);
}
