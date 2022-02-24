package entidades;

public abstract class Persona implements Comparable <Persona>{

	//propiedades
	
	private String Nombre;
	private String Ape1;
	private String Ape2;
	private ClaseDni Dni;

	
	//Constructores
	
	public Persona(String nombre, String ape1, String ape2, ClaseDni dni) {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApe1(ape1);
		this.setApe2(ape2);

	}

	public Persona(String nombre,String ape1,ClaseDni dni)
	{
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApe1(ape1);
		this.Ape2="";
	}

	
	//Getters and Setters
	
	public String getNombre() 
	{
		return Nombre;
	}


	private void setNombre(String nombre) 
	{
		Nombre = nombre;
	}


	public String getApe1() 
	{
		return Ape1;
	}


	private void setApe1(String ape1) 
	{
		Ape1 = ape1;
	}


	public String getApe2() 
	{
		return Ape2;
	}


	public void setApe2(String ape2) 
	{
		Ape2 = ape2;
	}


	public ClaseDni getDni() 
	{
		return Dni;
	}


	private void setDni(ClaseDni dni) 
	{
		Dni = dni;
	}

	//Metodos
	
	public String NombreCompleto ()
	{
		return this.Nombre+" "+this.Ape1+" "+this.Ape2;
	}
	
	public String InformacionCompleta ()
	{
		return NombreCompleto()+", con DNI:"+this.Dni;
	}
	
	@Override
	public String toString()
	{
		return this.InformacionCompleta();
	}
	
	
	@Override
	public boolean equals(Object obj)
	{
		Persona guest = (Persona) obj;
	
		return 	(this.Dni==guest.Dni);
	}


	@Override
	public int compareTo(Persona o) {
		int resultado=0;
		if ( this.NombreCompleto().compareTo(o.NombreCompleto())<0 )
		{
			resultado=-1;
		}
		else if (this.NombreCompleto().compareTo(o.NombreCompleto())>0 ) 
		{
			resultado = 1;
		}
		else
		{
			 if (this.Dni.compareTo(o.Dni)<0) 
			 {  
				 resultado = -1;    
			 } 
			 else if (this.Dni.compareTo(o.Dni)>0)
			 {   
				 resultado = 1;   
			 }
			 else 
			 {   
				 resultado = 0;   
			 }
	    }	
		
		return resultado;
	}

	
	
	
	
	
	
	
	
	
}