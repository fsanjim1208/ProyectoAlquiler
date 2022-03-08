package entidades;

import java.io.Serializable;

public class CarnetConducir implements Serializable{

	private static final long serialVersionUID = 8799656478674716601L;
	
	private String letra;
	private String Descripcion;
	
	
	public CarnetConducir(String letra, String descripcion) 
	{
		this.setLetra(letra);
		this.setDescripcion(descripcion);
	}

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
