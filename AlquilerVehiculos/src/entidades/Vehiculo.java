package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public abstract class Vehiculo implements Comparable <Vehiculo>,Serializable{

	//Propiedades
	
	private static final long serialVersionUID = 8799656478674716614L;
	
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int km;
	private GregorianCalendar fechaadquisicion;
	private Oficina oficina;
	private Categoria categoria;

	//Constructores
	/**
	 * Cosntructor del objeto Vehiculo
	 * @param matricula String unica para cada vehiculo
	 * @param marca String marca de cada vehiculo
	 * @param modelo String modelo de cada vehiculo
	 * @param color String color del vehiculo
	 * @param km in Km que tiene cada vehiculo
	 * @param fechaadquisicion GregorianCalendar fecha de adquision del vehiculo
	 * @param oficina Oficina Oficina en la que se encuentra el vehiculo
	 * @param categoria Categoria Categoria a la que pertence el vehiculo
	 */
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
	
	public void setMatricula(String matricula) 
	{
		this.matricula = matricula;
	}
	
	public String getMarca() 
	{
		return marca;
	}
	
	public void setMarca(String marca) 
	{
		this.marca = marca;
	}
	
	public String getModelo() 
	{
		return modelo;
	}
	
	public void setModelo(String modelo) 
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
		return this.marca+" de color "+this.color+" con matricula "+this.matricula+" y su categoria es "+this.categoria + " esta en "+this.oficina;
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
	
	public abstract double CalculaPrecio();

}
