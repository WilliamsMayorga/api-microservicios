package com.ideasconnections.microservicios.app.usuarios.services;

import java.util.List;

import com.ideasconnections.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.ideasconnections.microservicios.commons.alumnos.models.entity.Alumno;
import com.ideasconnections.microservicios.commons.services.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno,AlumnoRepository> implements AlumnoService {

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String term) {
        return repository.findByNombreOrApellido(term);
    }

	@Override
	public Iterable<Alumno> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

}
