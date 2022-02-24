package entidades;
import java.io.Serializable;

import metodos_personales.*;
public class ClaseDni implements Comparable <ClaseDni>, Serializable{

	private String letraDni;
	private int numeroDni;
	
	//CONSTRUCTOR
	
	public ClaseDni(String letraDni, int numeroDni) 
	{
		this.setLetraDni(letraDni);
		this.setNumeroDni(numeroDni);
	}
	
	public ClaseDni (String Dni)
	{
		int numero_dni=0;
		String letra_dni="";
		
		 if (Validadores.ValidaDni(Dni))
		 {
			 numero_dni = Integer.parseInt(Dni.substring(0,8));
			 letra_dni = "".concat(Dni.substring(8,9));
		 }
		 
			this.setLetraDni(letra_dni);
			this.setNumeroDni(numero_dni);
	}

	//GETTERS AND SETTERS
	public String getLetraDni() 
	{
		return letraDni;
	}
	
	public void setLetraDni(String letraDni) 
	{
		this.letraDni = letraDni;
	}
	
	public int getNumeroDni() 
	{
		return numeroDni;
	}
	
	public void setNumeroDni(int numeroDni) 
	{
		this.numeroDni = numeroDni;
	}

	
	
	//Metodos
	@Override
	public int compareTo(ClaseDni o) {
		return 0;
	}
	
	
	
	
}
