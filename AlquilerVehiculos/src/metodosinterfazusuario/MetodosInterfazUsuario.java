package metodosinterfazusuario;

import java.util.GregorianCalendar;

import entidades.*;
import metodos_personales.*;

public class MetodosInterfazUsuario {
	
	public static Persona PideDatosPersona () 
	{
		Persona persona = null ;
		
		String Nombre = Generales.PideDatosString("Introduzca el nombre del empleado");
		String Ape1 = Generales.PideDatosString("Introduzca el primer apellido del empleado");
		String Ape2 = Generales.PideDatosString("Introduzca el segundo apellido del empleado");
		String DNIemple = Generales.PideDatosString("Introduzca su Dni");
		ClaseDni Dni= new ClaseDni (DNIemple);
		
		persona = new Persona (Nombre, Ape1, Ape2, Dni);
		
		return persona;
	}
	
	
	public static Cliente PideDatosCliente()
	{
		Cliente cliente= null;
		
		Persona persona = PideDatosPersona(); 
		
		CarnetConducir tipoCarnet;
		int ntarjetaCliente = Generales.PideDatosNumericos("Introduzca el numero de la tarjeta de cliente");
		
		
		
		return cliente;
	}
	
	
	public static Empleado PideDatosEmpleado()
	{
		Empleado empleado= null;
		
		Persona persona = PideDatosPersona();
		GregorianCalendar fechaAltEmpleado;
		
		Oficina OficinaEmpleado = PideDatosOficina();
		
		return empleado;
	}
	
	public static Categoria PideDatosCategoria()
	{
		return null;
	}
	
	public static Oficina PideDatosOficina()
	{
		Oficina oficina=null;

		int Codigo = Generales.PideDatosNumericos("Introduce el Código de la oficina");
		String Descripcion= Generales.PideDatosString("Introduzca una pequeña descripcion de su oficina");
		String Localidad= Generales.PideDatosString("¿Dónde vive usted?");
		String Provincia=Generales.PideDatosString("¿A que provincia pertenece?");
		Boolean OficinaAeropuerto = true;
		
		oficina= new Oficina(Codigo, Descripcion, Localidad, Provincia, OficinaAeropuerto);
		
		return oficina;
	}
	
	public static Vehiculo PideDatosVehiculo()
	{
		return null;
	}
}
