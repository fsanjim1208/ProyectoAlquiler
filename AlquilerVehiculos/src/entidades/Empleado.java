package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudInvalidaException;


public class Empleado extends Persona implements Serializable{
	
	//Propiedades
	private GregorianCalendar fechaAltEmpleado;
	private Oficina OficinaEmpleado;

	

	public Empleado(String nombre, String ape1, ClaseDni dni) throws LongitudInvalidaException {
		super(nombre, ape1, dni);
		// TODO Auto-generated constructor stub
	}

	public Empleado(String nombre, String ape1, String ape2, ClaseDni dni,GregorianCalendar fechaAltEmpleado, Oficina OficinaEmpleado) throws LongitudInvalidaException {
		super(nombre, ape1, ape2, dni);
		// TODO Auto-generated constructor stub
	}

	
	//GETTERS AND SETTERS
	public GregorianCalendar getFechaAltEmpleado() {
		return fechaAltEmpleado;
	}

	public void setFechaAltEmpleado(GregorianCalendar fechaAltEmpleado) {
		this.fechaAltEmpleado = fechaAltEmpleado;
	}

	public Oficina getOficinaEmpleado() {
		return OficinaEmpleado;
	}

	public void setOficinaEmpleado(Oficina oficinaEmpleado) {
		OficinaEmpleado = oficinaEmpleado;
	}
	
	
	
}
