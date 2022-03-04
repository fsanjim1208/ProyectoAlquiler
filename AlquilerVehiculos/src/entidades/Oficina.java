package entidades;

import java.io.Serializable;

public class Oficina implements Serializable{
	
	private static final long serialVersionUID = 8799656478674716669L;

	private String Codigo;
	private String Descripcion;
	private String Localidad;
	private String Provincia;
	private Boolean OficinaAeropuerto;
	
	
	//CONSTRUCTORES
	public Oficina(String codigo, String descripcion, String localidad, String provincia, Boolean oficinaAeropuerto) {
		super();
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setOficinaAeropuerto(oficinaAeropuerto);
	}
	
	
	//GETTERS AND SETTERS
	public String getCodigo() 
	{
		return Codigo;
	}

	public void setCodigo(String codigo) 
	{
		Codigo = codigo;
	}

	public String getDescripcion() 
	{
		return Descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		Descripcion = descripcion;
	}

	public String getLocalidad() 
	{
		return Localidad;
	}

	public void setLocalidad(String localidad) 
	{
		Localidad = localidad;
	}

	public String getProvincia() 
	{
		return Provincia;
	}

	public void setProvincia(String provincia) 
	{
		Provincia = provincia;
	}

	public Boolean getOficinaAeropuerto() 
	{
		return OficinaAeropuerto;
	}

	public void setOficinaAeropuerto(Boolean oficinaAeropuerto) 
	{
		OficinaAeropuerto = oficinaAeropuerto;
	}




	
	
	
}
