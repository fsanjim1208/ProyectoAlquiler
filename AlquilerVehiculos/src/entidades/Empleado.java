package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

import excepciones.LongitudInvalidaException;


public class Empleado extends Persona implements Serializable{
	
	//Propiedades
	
	private static final long serialVersionUID = 8799656478674716608L;
	
	private GregorianCalendar fechaAltEmpleado;
	private Oficina OficinaEmpleado;

	

	public Empleado(String nombre, String ape1, String dni) throws LongitudInvalidaException {
		super(nombre, ape1, dni);
		// TODO Auto-generated constructor stub
	}

	public Empleado(String nombre, String ape1, String ape2, String dni,GregorianCalendar fechaAltEmpleado, Oficina OficinaEmpleado) throws LongitudInvalidaException {
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
	
	@Override
	public String toString() {
		return "Empleado "+ InformacionCompleta();
	}
	
	
	
}
