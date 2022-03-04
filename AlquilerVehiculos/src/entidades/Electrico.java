package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Electrico extends Vehiculo implements Serializable{



	//propiedades
	
	private static final long serialVersionUID = 8799656478674716669L;
	
	private int autonomia;
	private int tiempoRecarga;
	
	//Constructores
	
	public Electrico(String matricula, String marca, String modelo, String color, int km,
			GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria, int autonomia, int tiemporecarga) {
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria);
		this.setAutonomia(tiemporecarga);
		this.setTiempoRecarga(tiemporecarga);
	}
	
	//Getters and Setters
	
	public void setAutonomia(int autonimia) {
		this.autonomia = autonimia;
	}
	public void setTiempoRecarga(int tiempoRecarga) {
		this.tiempoRecarga = tiempoRecarga;
	}
	private int getAutonimia() {
		return autonomia;
	}
	private int getTiempoRecarga() {
		return tiempoRecarga;
	}
	
	//Metodos
	
}
