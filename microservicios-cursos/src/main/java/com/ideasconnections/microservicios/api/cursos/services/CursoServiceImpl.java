package com.ideasconnections.microservicios.api.cursos.services;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ideasconnections.microservicios.api.cursos.models.entity.Curso;
import com.ideasconnections.microservicios.api.cursos.models.repository.CursoRepository;
import com.ideasconnections.microservicios.commons.services.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}
}
