package com.ideasconnections.microservicios.app.usuarios.services;

import java.util.List;

import com.ideasconnections.microservicios.app.usuarios.client.CursoFeignClient;
import com.ideasconnections.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.ideasconnections.microservicios.commons.alumnos.models.entity.Alumno;
import com.ideasconnections.microservicios.commons.services.CommonServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno,AlumnoRepository> implements AlumnoService {

	@Autowired
	private CursoFeignClient clienteCurso;
	
    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String term) {
        return repository.findByNombreOrApellido(term);
    }

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public void eliminarCursoAlumnoPorId(Long id) {
		clienteCurso.eliminarCursoAlumnoPorId(id);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		super.deleteById(id);
		this.eliminarCursoAlumnoPorId(id);
	}
	
	

}
