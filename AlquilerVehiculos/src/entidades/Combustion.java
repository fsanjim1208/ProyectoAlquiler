package entidades;

import java.util.GregorianCalendar;

public class Combustion extends Vehiculo {


	//Propiedades
	
	private String consumo;
	private int potencia;
	private String nivelEmisiones;
	
	//Constructores
	
	public Combustion(String matricula, String marca, String modelo, String color, int km,
			GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria,String nivelemisiones) 
	{
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria);
		this.setConsumo(consumo);
		this.setPotencia(potencia);
		this.setNivelEmisiones(nivelemisiones);
	}


	
	//Getters and Setters
	
	public String getConsumo() 
	{
		return consumo;
	}

	private void setConsumo(String consumo) 
	{
		this.consumo = consumo;
	}

	public int getPotencia() 
	{
		return potencia;
	}

	private void setPotencia(int potencia) 
	{
		this.potencia = potencia;
	}

	public String getNivelEmisiones() 
	{
		return nivelEmisiones;
	}

	private void setNivelEmisiones(String nivelEmisiones) 
	{
		this.nivelEmisiones = nivelEmisiones;
	}
	
	//Metodos
	
	
	
}
