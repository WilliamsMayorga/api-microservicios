package com.ideasconnections.microservicios.app.respuestas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideasconnections.microservicios.app.respuestas.clients.ExamenFeignClient;
import com.ideasconnections.microservicios.app.respuestas.models.entity.Respuesta;
import com.ideasconnections.microservicios.app.respuestas.models.repository.RespuestaRepository;

@Service
public class RespuestaServiceImp implements RespuestaService {

	@Autowired
	private ExamenFeignClient examenClient;

	@Autowired
	private RespuestaRepository repository;

	@Override
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return repository.saveAll(respuestas);
	}

	@Override
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {

		List<Respuesta> respuestas = (List<Respuesta>) repository.findRespuestaByAlumnoByExamen(alumnoId, examenId);

		return respuestas;
	}

	@Override
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
		List<Respuesta> respuestaAlumno = (List<Respuesta>) repository.findExamenesIdsConRespuestasByAlumno(alumnoId);
		List<Long> examenesIds = respuestaAlumno.stream().map(respuesta -> respuesta.getPregunta().getExamen().getId())
				.distinct().collect(Collectors.toList());
		return examenesIds;
	}

	@Override
	public Iterable<Respuesta> findByAlumnoId(Long alumnoId) {
		return repository.findByAlumnoId(alumnoId);
	}

}
