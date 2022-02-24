package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;

public class Profesores {

	ArrayList<Profesor> coleccionProfesores;

	public Profesores() {
		
		coleccionProfesores = new ArrayList<>();
	}
	
	public Profesores(Profesores profesores) {

		setProfesores(profesores);

	}
	
	private void setProfesores(Profesores profesores) {
		
		if (profesores == null) {
			throw new NullPointerException("ERROR: No se pueden copiar profesores nulos.");
		}
		
		/*if (profesores.getProfesores().isEmpty()) {
			throw new IllegalArgumentException("ERROR: La lista de profesores no puede estar vacía.");
		}*/
		
		coleccionProfesores = profesores.getProfesores();
	}

	public ArrayList<Profesor> getProfesores() {
		return copiaProfundaProfesores(coleccionProfesores);
	}
	
	public int getNumProfesores() {
		
		return coleccionProfesores.size();
	}

	private ArrayList<Profesor> copiaProfundaProfesores(ArrayList<Profesor> profesores) {
		ArrayList<Profesor> copiaProfesores = new ArrayList<Profesor>();
		Iterator<Profesor> iterador = profesores.iterator();
		
		while(iterador.hasNext()) {
			copiaProfesores.add(new Profesor(iterador.next()));
		}
		
		return copiaProfesores;
	}

	public void insertar(Profesor insertarProfesor) throws OperationNotSupportedException {
		
		if (insertarProfesor == null) {
			throw new NullPointerException("ERROR: No se puede insertar un profesor nulo.");
		}
		
		if (!coleccionProfesores.contains(insertarProfesor)) {
			coleccionProfesores.add(insertarProfesor);
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un profesor con ese nombre.");
		}
		

	}

	public Profesor buscar(Profesor buscarProfesor) {
		if (buscarProfesor == null) {
			throw new NullPointerException("ERROR: No se puede buscar un profesor nulo.");
		}
	
		Iterator<Profesor> iterador = coleccionProfesores.iterator();
		
		while(iterador.hasNext()) {
			Profesor profesorBuscado = iterador.next();
			if(buscarProfesor.equals(profesorBuscado)) {
				return new Profesor(profesorBuscado);
			}
		}
		return null;

	}

	public void borrar(Profesor borrarProfesor) throws OperationNotSupportedException {
		if (borrarProfesor == null) {
			throw new NullPointerException("ERROR: No se puede borrar un profesor nulo.");
		}
		
		if (coleccionProfesores.contains(borrarProfesor)) {
			coleccionProfesores.remove(borrarProfesor);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ningún profesor con ese nombre.");
		}

	}

	public ArrayList<String> representar() {
		ArrayList<String> representacion = new ArrayList<String>();
		Iterator<Profesor> iterador = coleccionProfesores.iterator();
		while (iterador.hasNext()) {
			Profesor profesorRepresentado = iterador.next();
			representacion.add(profesorRepresentado.toString());
		}
		return representacion;
	}

}
