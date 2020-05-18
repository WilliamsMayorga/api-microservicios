package com.ideasconnections.microservicios.app.respuestas.services;

import com.ideasconnections.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestaService {
	public Iterable<Respuesta> savaAll(Iterable<Respuesta> respuestas);
	
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);
}
