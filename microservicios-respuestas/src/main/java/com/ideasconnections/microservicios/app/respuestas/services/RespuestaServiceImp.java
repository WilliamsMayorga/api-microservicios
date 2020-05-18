package com.ideasconnections.microservicios.app.respuestas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ideasconnections.microservicios.app.respuestas.models.entity.Respuesta;
import com.ideasconnections.microservicios.app.respuestas.models.repository.RespuestaRepository;

@Service
public class RespuestaServiceImp implements RespuestaService {

	@Autowired
	private RespuestaRepository repository;

	@Override
	@Transactional
	public Iterable<Respuesta> savaAll(Iterable<Respuesta> respuestas) {
		return repository.saveAll(respuestas);
	}

}
