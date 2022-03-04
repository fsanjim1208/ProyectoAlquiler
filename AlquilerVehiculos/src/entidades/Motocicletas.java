package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Motocicletas extends Electrico implements Serializable{

	//Propiedades
	
	private static final long serialVersionUID = 8799656478674716669L;
	
	private int cilindrada;
	private CarnetConducir CarnetRequerido;
	
	//Constructores
	public Motocicletas(String matricula, String marca, String modelo, String color, int km,
			GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria, int autonomia,
			int tiemporecarga,int cilindrada, CarnetConducir carnetrequerido) 
	{
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, autonomia, tiemporecarga);
		this.setCilindrada(cilindrada);
		this.setCarnetRequerido(carnetrequerido);
	}

	//Getters and Setters

	public int getCilindrada() 
	{
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) 
	{
		this.cilindrada = cilindrada;
	}

	public CarnetConducir getCarnetRequerido() 
	{
		return CarnetRequerido;
	}

	private void setCarnetRequerido(CarnetConducir carnetRequerido) 
	{
		CarnetRequerido = carnetRequerido;
	}
	
	//Metodos
	
}
