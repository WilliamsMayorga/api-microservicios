package com.ideasconnections.microservicios.app.respuestas.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ideasconnections.microservicios.commons.alumnos.models.entity.Alumno;
import com.ideasconnections.microservicios.commons.examenes.models.entity.Pregunta;

@Entity
@Table(name = "respuestas")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String texto;

	// @ManyToOne(fetch = FetchType.LAZY)
	@Transient
	private Alumno alumno;

	@Column(name = "alumno_id")
	private Long AlumnoId;

	@OneToOne(fetch = FetchType.LAZY)
	private Pregunta pregunta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Long getAlumnoId() {
		return AlumnoId;
	}

	public void setAlumnoId(Long alumnoId) {
		AlumnoId = alumnoId;
	}
}
