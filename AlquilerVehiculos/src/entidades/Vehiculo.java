package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Vehiculo implements Comparable <Vehiculo>,Serializable{

	//Propiedades
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int km;
	private GregorianCalendar fechaadquisicion;
	private Oficina oficina;
	private Categoria categoria;

	//Constructores
	
	public Vehiculo(String matricula, String marca, String modelo, String color,int km,GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria) {
		this.setMatricula(matricula);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setColor(color);
		this.setKm(km);
		this.setFechaadquisicion(fechaadquisicion);
		this.setOficina(oficina);
		this.setCategoria(categoria);
	}
	
	//Getters and Setters
	
	public String getMatricula() 
	{
		return matricula;
	}
	
	private void setMatricula(String matricula) 
	{
		this.matricula = matricula;
	}
	
	public String getMarca() 
	{
		return marca;
	}
	
	private void setMarca(String marca) 
	{
		this.marca = marca;
	}
	
	public String getModelo() 
	{
		return modelo;
	}
	
	private void setModelo(String modelo) 
	{
		this.modelo = modelo;
	}
	
	public String getColor() 
	{
		return color;
	}
	
	private void setColor(String color) 
	{
		this.color = color;
	}
	
	public int getKm() 
	{
		return km;
	}
	
	public void setKm(int km) 
	{
		this.km = km;
	}
	
	public GregorianCalendar getFechaadquisicion() 
	{
		return fechaadquisicion;
	}
	
	private void setFechaadquisicion(GregorianCalendar fechaadquisicion) 
	{
		this.fechaadquisicion = fechaadquisicion;
	}
	
	public Oficina getOficina() 
	{
		return oficina;
	}
	
	public void setOficina(Oficina oficina) 
	{
		this.oficina = oficina;
	}
	
	public Categoria getCategoria() 
	{
		return categoria;
	}
	
	private void setCategoria(Categoria categoria) 
	{
		this.categoria = categoria;
	}
	
	
	//metodos
	public String InformacionVehiculo()
	{
		return this.marca+" de color "+this.color+" con matricula "+this.matricula;
	}
	
	@Override
	public String toString()
	{
		return this.InformacionVehiculo();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Vehiculo guest = (Vehiculo) obj;
	
		return 	(this.matricula==guest.matricula);
	}

	@Override
	public int compareTo(Vehiculo o) {
		return this.matricula.compareTo(o.matricula);
	}

}
