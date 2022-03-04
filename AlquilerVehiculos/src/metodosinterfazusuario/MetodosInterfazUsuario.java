package metodosinterfazusuario;

import java.util.GregorianCalendar;

import entidades.*;
import excepciones.LongitudInvalidaException;
import metodos_personales.*;

public class MetodosInterfazUsuario {
	

	
	public static Cliente PideDatosCliente()
	{
		Cliente cliente= null;
		
		String Nombre = Generales.PideDatosString("Introduzca el nombre del empleado");
		String Ape1 = Generales.PideDatosString("Introduzca el primer apellido del empleado");
		String Ape2 = Generales.PideDatosString("Introduzca el segundo apellido del empleado");
		String DNIemple = Generales.PideDatosString("Introduzca su Dni");
		ClaseDni Dni= new ClaseDni (DNIemple);
		
		CarnetConducir tipoCarnet;
		int ntarjetaCliente = Generales.PideDatosNumericos("Introduzca el numero de la tarjeta de cliente");
		
		
		
		return cliente;
	}
	
	
	
	public static ClaseDni PideDatosDni()
	{
		String DNIemple = Generales.PideDatosString("Introduzca su Dni");
		ClaseDni Dni= new ClaseDni (DNIemple);
		return Dni;
	}
	
	public static Empleado PideDatosEmpleado()
	{
		Empleado empleado= null;
	
		String Nombre = Generales.PideDatosString("Introduzca el nombre del empleado");
		String Ape1 = Generales.PideDatosString("Introduzca el primer apellido del empleado");
		String Ape2 = Generales.PideDatosString("Introduzca el segundo apellido del empleado");
		ClaseDni Dni= PideDatosDni();
		GregorianCalendar fechaAltEmpleado = null;
		
		Oficina OficinaEmpleado = PideDatosOficina();
		
		try 
		{
			empleado = new Empleado (Nombre, Ape1, Ape2,Dni,fechaAltEmpleado, OficinaEmpleado);
		} 
		catch (LongitudInvalidaException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		Vehiculo vehiculo = null;
		
		String matricula = Generales.PideDatosString("Introduzca la matricula del vehiculo");
		String marca = Generales.PideDatosString("Introduzca la marca");
		String modelo = Generales.PideDatosString("Introduza el modelo");
		String color = Generales.PideDatosString("¿De que color es?");
		int km = Generales.PideDatosNumericos("¿Cuantos KM tiene el coche?");
		GregorianCalendar fechaadquisicion= null;
		Oficina oficina= PideDatosOficina();
		Categoria categoria = PideDatosCategoria();
		
		int eleccionUsuario;
		int eleccionUsuario2;
		
		do 
		{
			System.out.println("¿Que tipo de motor es?");
			System.out.println("1-Combustion");
			System.out.println("2-Electrico");
			eleccionUsuario = Generales.PideDatosNumericos("");
				
			if (eleccionUsuario == 1)
			{
				
				do
				{
					System.out.println("COMBUSTIÓN");
					System.out.println("¿Que tipo de vehiculo es?");
					System.out.println("1-Coche");
					System.out.println("2-Furgoneta");
					eleccionUsuario2 = Generales.PideDatosNumericos("");
					
					if (eleccionUsuario2 == 1)
					{
						
					}
					else if (eleccionUsuario2 == 2)
					{

					}
					else
					{
						System.out.println("Introduzca un numero entre 1 y 2");
					}
					
				} while (eleccionUsuario2<1 && eleccionUsuario2>2);
			}
			else if(eleccionUsuario == 2)
			{
				do 
				{
					
					System.out.println("¿Que tipo de vehiculo es?");
					System.out.println("1-Coche");
					System.out.println("2-Motociclieta");
					eleccionUsuario2 = Generales.PideDatosNumericos("");
				} while (eleccionUsuario2<1 && eleccionUsuario2>2);
			}
			else 
			{
				System.out.println("Introduzca un numero entre 1 y 2");
			}
		}	while (eleccionUsuario<1 && eleccionUsuario>2);
		return vehiculo;
	}
}





