package metodosinterfazusuario;

import entidades.*;
import metodos_personales.*;

public class MetodosInterfazUsuario {

	public static Cliente PideDatosCliente()
	{
		Cliente cliente= null;
		String Dni = Generales.PideDatosString("Introduce su Dni");
		
		return null;
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
		String Localidad;
		String Provincia;
		Boolean OficinaAeropuerto;
		
		
		
		
		return oficina;
	}
	
	public static Empleado PideDatosEmpleado()
	{
		return null;
	}
	
	public static Vehiculo PideDatosVehiculo()
	{
		return null;
	}
}
