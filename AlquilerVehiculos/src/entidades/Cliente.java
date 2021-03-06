package entidades;

import java.io.Serializable;

import excepciones.LongitudInvalidaException;

public class Cliente extends Persona implements Serializable {
	
	private static final long serialVersionUID = 8799656478674716603L;
	
	private CarnetConducir tipoCarnet;
	private int ntarjetaCliente;
	
	
	//Constructores
	
	public Cliente(String nombre, String ape1, String ape2, String dni,CarnetConducir tipoCarnet, int ntarjetacliente) throws LongitudInvalidaException 
	{
		super(nombre, ape1, ape2, dni);
		this.setTipoCarnet(tipoCarnet);
		this.setNtarjetaCliente(ntarjetacliente);
	}

	public Cliente(String nombre, String ape1, String dni,CarnetConducir tipoCarnet, int ntarjetacliente) throws LongitudInvalidaException 
	{
		super(nombre, ape1, dni);
		
	}

	public CarnetConducir getTipoCarnet() 
	{
		return tipoCarnet;
	}

	public void setTipoCarnet(CarnetConducir tipoCarnet) 
	{
		this.tipoCarnet = tipoCarnet;
	}

	public int getNtarjetaCliente() 
	{
		return ntarjetaCliente;
	}

	public void setNtarjetaCliente(int ntarjetaCliente) 
	{
		this.ntarjetaCliente = ntarjetaCliente;
	}
	
	
	
}
