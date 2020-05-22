package isi.died2020.parcial01.ejercicio02.app;


import java.util.ArrayList;
import java.util.Collections;

import isi.died2020.parcial01.ejercicio02.db.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import isi.died2020.parcial01.ejercicio02.dominio.*;
import isi.died2020.parcial01.ejercicio02.dominio.Inscripcion.Estado;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	
	public void registrarNota(Examen e, Integer nota) {
		e.setNota(nota);
		if(nota.intValue()>6) {
			List<Inscripcion> temp = e.getAlumno().getMateriasCursadas();
			for(int i = temp.size()-1; i>=0;i--) {
				if(temp.get(i).getMateria()==e.getMateria()) {
					temp.get(i).setEstado(Estado.PROMOCIONADO);
				}
			}
		}
	}
	
	public List<Examen> topNExamenes(Alumno a, Integer n, Integer nota){
		List<Examen> listaExamenes = a.getExamenes().stream()
			.filter(e->e.getNota()>=nota)
			.sorted((e1, e2) -> e1.getNota()-e2.getNota())
			.limit(n)
			.collect(Collectors.toList());
		
		listaExamenes.sort((e1,e2)->e2.getNota()-e1.getNota());
		return listaExamenes;
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws AlumnoYaInscriptoException, NoSePudoGuardarException {
			Optional<Inscripcion> inscripcionPrevia = a.getMateriasCursadas().stream()
				.filter(i->i.getMateria()==m)
				.findFirst();
			if(inscripcionPrevia.isPresent()) {
				if(inscripcionPrevia.get().getEstado()!=Estado.LIBRE) {
					throw new AlumnoYaInscriptoException("El alumno ya se encuentra inscripto en un estado diferente a LIBRE");
				}
			}
			Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
			d.agregarInscripcion(insc);
			a.addCursada(insc);
			m.addInscripcion(insc);
		try {
		DB.guardar(insc);
		}
		catch(BaseDeDatosExcepcion e) {
			throw new NoSePudoGuardarException("No se pudo guardar la inscripción");
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}
	

}
