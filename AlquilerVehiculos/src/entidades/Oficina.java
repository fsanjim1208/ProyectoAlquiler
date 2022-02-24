package entidades;

public class Oficina {

	private int Codigo;
	private String Descripcion;
	private String Localidad;
	private String Provincia;
	private Boolean OficinaAeropuerto;
	
	
	//CONSTRUCTORES
	public Oficina(int codigo, String descripcion, String localidad, String provincia, Boolean oficinaAeropuerto) {
		super();
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setOficinaAeropuerto(oficinaAeropuerto);
	}
	
	
	//GETTERS AND SETTERS
	public int getCodigo() 
	{
		return Codigo;
	}

	public void setCodigo(int codigo) 
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
