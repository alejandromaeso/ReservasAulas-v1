package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Permanencia {
	
	private LocalDate dia;
	private final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/M/yyyy");
	
	private Tramo tramo;
	
	public Permanencia(LocalDate dia, Tramo tramo) {

		setDia(dia);
		setTramo(tramo);

	}

	public Permanencia(Permanencia copiaPermanencia) {
		if(copiaPermanencia == null) {
			throw new NullPointerException("ERROR: No se puede copiar una permanencia nula.");
		}
		setTramo(copiaPermanencia.getTramo());
		setDia(copiaPermanencia.getDia());
	}
	
	//Getters & Setters
	
	public LocalDate getDia() {
		return dia;
	}

	private void setDia(LocalDate dia) {
		if(dia == null) {
			throw new NullPointerException("ERROR: El día de una permanencia no puede ser nulo.");
		}
	
		LocalDate fechaActual = LocalDate.now();
		if(dia.compareTo(fechaActual) < 0) {
			throw new IllegalArgumentException("ERROR: No puedes introducir una fecha anterior a la actual.");
		}
		
		this.dia = dia;
	}

	public Tramo getTramo() {
		return tramo;
	}

	private void setTramo(Tramo tramo) {
		if(tramo == null) {
			throw new NullPointerException("ERROR: El tramo de una permanencia no puede ser nulo.");
		}
		this.tramo = tramo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, tramo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permanencia other = (Permanencia) obj;
		return Objects.equals(dia, other.dia) && tramo == other.tramo;
	}

	@Override
	public String toString() {
		return "dia=" + dia.format(FORMATO_DIA) + ", tramo=" + tramo;
	}
	
	
	

}
