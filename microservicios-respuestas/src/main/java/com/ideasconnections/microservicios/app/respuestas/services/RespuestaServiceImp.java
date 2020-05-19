package com.ideasconnections.microservicios.app.respuestas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ideasconnections.microservicios.app.respuestas.clients.ExamenFeignClient;
import com.ideasconnections.microservicios.app.respuestas.models.entity.Respuesta;
import com.ideasconnections.microservicios.app.respuestas.models.repository.RespuestaRepository;
import com.ideasconnections.microservicios.commons.examenes.models.entity.Examen;

@Service
public class RespuestaServiceImp implements RespuestaService {

	@Autowired
	private ExamenFeignClient examenClient;

	@Autowired
	private RespuestaRepository repository;

	@Override
	@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return repository.saveAll(respuestas);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
		return null;
	}

}
