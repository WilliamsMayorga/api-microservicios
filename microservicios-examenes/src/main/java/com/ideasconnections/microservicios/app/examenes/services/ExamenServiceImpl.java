package com.ideasconnections.microservicios.app.examenes.services;

import org.springframework.stereotype.Service;

import com.ideasconnections.microservicios.app.examenes.models.entity.Examen;
import com.ideasconnections.microservicios.app.examenes.models.respository.ExamenRepository;
import com.ideasconnections.microservicios.commons.services.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService{
}
