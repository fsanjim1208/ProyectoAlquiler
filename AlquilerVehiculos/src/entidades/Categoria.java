package entidades;

import java.io.Serializable;

public class Categoria implements Serializable{

	private static final long serialVersionUID = 8799656478674716602L;
	
	//PROPIEDADES
	private String Codigo;
	private String Descripcion;
	private int recargo;

	
	//CONSTRUCTORES 
	public Categoria(String codigo, String descripcion, int recargo) 
	{
		this.setCodigo(codigo);
		this.setDescripcion(descripcion);
		this.setRecargo(recargo);
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

	public int getRecargo() {
		return recargo;
	}

	public void setRecargo(int recargo) 
	{
		this.recargo = recargo;
	}


	@Override
	public String toString() {
		return "Categoria " + Descripcion + " con codigo -"+Codigo + "- con un recargo del " + recargo + "%";
	}
	
	


	
}
