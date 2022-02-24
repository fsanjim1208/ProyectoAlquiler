package entidades;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
	private CarnetConducir tipoCarnet;
	private int ntarjetaCliente;
	
	

	
	
	
	
	//Constructores
	
	public Cliente(String nombre, String ape1, String ape2, ClaseDni dni) 
	{
		super(nombre, ape1, ape2, dni);
		
	}

	public Cliente(String nombre, String ape1, ClaseDni dni) 
	{
		super(nombre, ape1, dni);

	}
	
}
