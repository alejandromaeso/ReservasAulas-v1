package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import java.util.ArrayList;
import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;

public class Aulas {

	ArrayList<Aula> coleccionAulas;

	public Aulas() {

		coleccionAulas = new ArrayList<Aula>();
	}

	public Aulas(Aulas aulas) {
		setAulas(aulas);
	}

	private void setAulas(Aulas aulas) {
		if (aulas == null) {
			throw new NullPointerException("ERROR: No se pueden copiar aulas nulas.");
		}
		/*if (aulas.getAulas().isEmpty()) {
			throw new IllegalArgumentException("ERROR: La lista de aulas no puede estar vacía.");
		}*/

		coleccionAulas = aulas.getAulas();
	}

	public ArrayList<Aula> getAulas() {
		
		//Devuelvo una copia para evitar el aliasing
		
		return copiaProfundaAulas(coleccionAulas);
	}

	private ArrayList<Aula> copiaProfundaAulas(ArrayList<Aula> listaAulas) {
		ArrayList<Aula> copiaAulas = new ArrayList<Aula>();
		Iterator<Aula> iterador = listaAulas.iterator();
		while (iterador.hasNext()) {
			copiaAulas.add(new Aula(iterador.next()));
		}
		return copiaAulas;
	}
	
	public int getNumAulas() {
		return coleccionAulas.size();
		
	}

	public void insertar(Aula insertarAula) throws OperationNotSupportedException {
		if (insertarAula == null) {
			throw new NullPointerException("ERROR: No se puede insertar un aula nula.");
		}

		if (!coleccionAulas.contains(insertarAula)) {
			coleccionAulas.add(insertarAula);
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un aula con ese nombre.");
		}
		
	}
	
	public Aula buscar(Aula buscarAula) {
		if (buscarAula == null) {
			throw new NullPointerException("ERROR: No se puede buscar un aula nula.");
		}
		
		Iterator<Aula> iterador = coleccionAulas.iterator();
		while (iterador.hasNext()) {
			Aula aulaBuscada = iterador.next(); 
			if(buscarAula.equals(aulaBuscada)){
				return new Aula(aulaBuscada);
			}
		}
		return null;
	}

	public void borrar(Aula borrarAula) throws OperationNotSupportedException {
		if (borrarAula == null) {
			throw new NullPointerException("ERROR: No se puede borrar un aula nula.");
		}
		
		
		if (coleccionAulas.contains(borrarAula)) {
			coleccionAulas.remove(borrarAula);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ningún aula con ese nombre.");
		}

	}

	public ArrayList<String> representar() {
		ArrayList<String> representacion = new ArrayList<String>();
		Iterator<Aula> iterador = coleccionAulas.iterator();
		while (iterador.hasNext()) {
			Aula aulaRepresentada = iterador.next();
			representacion.add(aulaRepresentada.toString());
		}

		return representacion;
	}

}
