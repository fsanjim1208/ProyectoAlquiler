package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Furgonetas extends Combustion implements Serializable{


	//Propiedades
	private int CapacidadCarga;
	private CarnetConducir CarnetRequerido;
	
	//Constructores
	public Furgonetas(String matricula, String marca, String modelo, String color, int km,
			GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria, String nivelemisiones,
			int capacidadcarga, CarnetConducir carnetrequerido) {
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, nivelemisiones);
		this.setCapacidadCarga(capacidadcarga);
		this.setCarnetRequerido(carnetrequerido);
	}
		
	//Getters and Setters
	public int getCapacidadCarga() {
		return CapacidadCarga;
	}
	public void setCapacidadCarga(int capacidadCarga) {
		CapacidadCarga = capacidadCarga;
	}
	public CarnetConducir getCarnetRequerido() {
		return CarnetRequerido;
	}
	public void setCarnetRequerido(CarnetConducir carnetRequerido) {
		CarnetRequerido = carnetRequerido;
	}
	
	//metodos
}
