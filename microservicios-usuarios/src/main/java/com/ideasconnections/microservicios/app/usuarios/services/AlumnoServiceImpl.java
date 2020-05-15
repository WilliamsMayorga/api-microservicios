package com.ideasconnections.microservicios.app.usuarios.services;

import com.ideasconnections.microservicios.app.usuarios.models.entity.Alumno;
import com.ideasconnections.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.ideasconnections.microservicios.commons.services.CommonServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository>implements AlumnoService {
}
