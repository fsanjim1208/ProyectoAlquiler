package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class CochesCombustion extends Combustion implements Serializable{

	//Propiedades
	
	private int Nplazas;
	private String tipo;

	//Constructores
	
	
	public CochesCombustion(String matricula, String marca, String modelo, String color, int km,
			GregorianCalendar fechaadquisicion, Oficina oficina, Categoria categoria,
			String nivelemisiones,	int numeroplazas, String tipo) 
	{
		super(matricula, marca, modelo, color, km, fechaadquisicion, oficina, categoria, nivelemisiones);
		this.setNplazas(numeroplazas);
		this.setTipo(tipo);
	}



	///Getters and Setters
	
		public int getNplazas() {
		return Nplazas;
	}

	private void setNplazas(int nplazas) {
		Nplazas = nplazas;
	}

	public String getTipo() {
		return tipo;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//Metodos
	
}
