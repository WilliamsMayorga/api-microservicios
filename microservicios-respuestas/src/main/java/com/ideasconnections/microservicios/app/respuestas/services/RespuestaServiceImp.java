package com.ideasconnections.microservicios.app.respuestas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideasconnections.microservicios.app.respuestas.clients.ExamenFeignClient;
import com.ideasconnections.microservicios.app.respuestas.models.entity.Respuesta;
import com.ideasconnections.microservicios.app.respuestas.models.repository.RespuestaRepository;
import com.ideasconnections.microservicios.commons.examenes.models.entity.Examen;
import com.ideasconnections.microservicios.commons.examenes.models.entity.Pregunta;

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
		Examen examen = examenClient.obtenerExamenPorId(examenId);
		List<Pregunta> preguntas = examen.getPreguntas();
		List<Long> preguntaIds = preguntas.stream().map(pregunta -> pregunta.getId()).collect(Collectors.toList());
		List<Respuesta> respuestas = (List<Respuesta>) repository.findRespuestaByAlumnoByPreguntaIds(alumnoId,
				preguntaIds);
		respuestas = respuestas.stream().map(respuesta -> {
			preguntas.forEach(pregunta -> {
				if (pregunta.getId() == respuesta.getPreguntaId()) {
					respuesta.setPregunta(pregunta);
				}
			});
			return respuesta;
		}).collect(Collectors.toList());
		return respuestas;
	}

	@Override
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
		return null;
	}

}
