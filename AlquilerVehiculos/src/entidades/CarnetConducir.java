package entidades;

import java.io.Serializable;

public class CarnetConducir implements Serializable{

	private static final long serialVersionUID = 8799656478674716601L;
	
	private String letra;
	private String Descripcion;
	
	//CONSTRUCTOR
	/**
	 * 	Constructor del objeto CarnetConducir
	 * @param letra letra que identifica al carnet
	 * @param descripcion peque�a descripcion del carnet
	 */
	public CarnetConducir(String letra, String descripcion) 
	{
		this.setLetra(letra);
		this.setDescripcion(descripcion);
	}

	//GUETTERS AND SETTERS
	public String getLetra() 
	{
		return letra;
	}

	public void setLetra(String letra) 
	
	{
		this.letra = letra;
	}

	public String getDescripcion() 
	{
		return Descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		Descripcion = descripcion;
	}


	
	
}
