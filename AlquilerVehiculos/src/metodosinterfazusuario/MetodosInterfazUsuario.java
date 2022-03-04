package metodosinterfazusuario;

import java.util.GregorianCalendar;

import entidades.*;
import excepciones.LongitudInvalidaException;
import metodos_personales.*;

public class MetodosInterfazUsuario {
	
	public static GregorianCalendar PideDatosFecha()
	{
		GregorianCalendar fecha = null;
		int dia = Generales.PideDatosNumericos("Dia");
		int mes = Generales.PideDatosNumericos("Mes");
		int año = Generales.PideDatosNumericos("Año");
		
		fecha = new GregorianCalendar(dia, mes, año);
		
		return fecha;
	}
	
	public static Alquiler PideDatosAlquiler() throws LongitudInvalidaException 
	{
		Alquiler alquiler=null;
		String codigo = Generales.PideDatosString("Introduce el codigo del alquiler");
		Cliente cliente = PideDatosCliente();
		Empleado empleado = PideDatosEmpleado();
		Vehiculo vehiculo_alqiuilado = PideDatosVehiculo();
		Oficina lugar_alquiler = PideDatosOficina();
		GregorianCalendar fecha_alquila = PideDatosFecha();
		GregorianCalendar fecha_devuelve = PideDatosFecha();
		
		alquiler= new Alquiler(codigo, cliente, empleado, vehiculo_alqiuilado, lugar_alquiler, fecha_alquila, fecha_devuelve);
		
		return null;
	}

	public static Cliente PideDatosCliente() throws LongitudInvalidaException
	{
		Cliente cliente= null;
		
		String Nombre = Generales.PideDatosString("Introduzca el nombre del empleado");
		String Ape1 = Generales.PideDatosString("Introduzca el primer apellido del empleado");
		String Ape2 = Generales.PideDatosString("Introduzca el segundo apellido del empleado");
		String DNIcliente = Generales.PideDatosString("Introduzca su Dni");
		ClaseDni Dni= new ClaseDni (DNIcliente);
		
		CarnetConducir tipoCarnet = PideDatosCarnet();
		int ntarjetaCliente = Generales.PideDatosNumericos("Introduzca el numero de la tarjeta de cliente");
		
		cliente = new Cliente(Nombre, Ape1,Ape2, Dni, tipoCarnet, ntarjetaCliente);
		
		return cliente;
	}
	
	public static CarnetConducir PideDatosCarnet()
	{
		CarnetConducir carnet = null;
		
		String letra = Generales.PideDatosString("Introduzca la letra del Carnetk");
		String Descripcion = Generales.PideDatosString("Introduzca su Dni");
		
		carnet = new CarnetConducir(letra, Descripcion);
		
		return carnet;
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
		GregorianCalendar fechaAltEmpleado = PideDatosFecha();
		
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
		Categoria categoria = null;
		
		String Codigo = Generales.PideDatosString("Codigo de la categoria");
		String Descripcion = Generales.PideDatosString("Codigo de la categoria");
		int recargo = Generales.PideDatosNumericos("Introduzca el recargo");
		
		categoria = new Categoria(Codigo, Descripcion, recargo);
		
		return categoria;
	}
	
	public static Oficina PideDatosOficina()
	{
		Oficina oficina=null;

		String Codigo = Generales.PideDatosString("Introduce el Código de la oficina");
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
		GregorianCalendar fechaadquisicion = PideDatosFecha();
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
					Generales.SubrayaString("COMBUSTIÓN", "_");
					System.out.println("¿Que tipo de vehiculo es?");
					System.out.println("1-Coche");
					System.out.println("2-Furgoneta");
					eleccionUsuario2 = Generales.PideDatosNumericos("");
					
					if (eleccionUsuario2 == 1)
					{
						String consumo = Generales.PideDatosString("¿Cual es el consumo promedio de este coche?");
						int potencia = Generales.PideDatosNumericos("¿Que potencia dispone este coche?");
						String nivelEmisiones = Generales.PideDatosString("¿Cual es el nivel de emision de gases promedio de este coche?");
						int Nplazas = Generales.PideDatosNumericos("¿Cuantas plazas tiene este coche?");
						String tipo = Generales.PideDatosString("¿Que tipo de coche es?");
						
						vehiculo = new CochesCombustion(matricula, marca, modelo, color, km, fechaadquisicion,
														oficina, categoria, nivelEmisiones, Nplazas, tipo);
						
					}
					else if (eleccionUsuario2 == 2)
					{
						String consumo = Generales.PideDatosString("¿Cual es el consumo promedio de este coche?");
						int potencia = Generales.PideDatosNumericos("¿Que potencia dispone esta furgoneta?");
						String nivelEmisiones = Generales.PideDatosString("¿Cual es el nivel de emision de gases promedio de este coche?");
						int CapacidadCarga = Generales.PideDatosNumericos("¿Que potencia dispone esta furgoneta?");;
						CarnetConducir CarnetRequerido = null;
						
						vehiculo = new Furgonetas(matricula, marca, modelo, color, km, fechaadquisicion, oficina,
													categoria, nivelEmisiones, CapacidadCarga, CarnetRequerido);
						
					}
					else
					{
						System.out.println("Introduzca un numero entre 1 y 2");
					}
					
				} while (eleccionUsuario2>=1 && eleccionUsuario2<=2);
			}
			else if(eleccionUsuario == 2)
			{
				do 
				{
					Generales.SubrayaString("ELECTRICO", "_");
					System.out.println("¿Que tipo de vehiculo es?");
					System.out.println("1-Coche");
					System.out.println("2-Motociclieta");
					eleccionUsuario2 = Generales.PideDatosNumericos("");
					
					if (eleccionUsuario2 == 1)
					{
						int autonomia = Generales.PideDatosNumericos("¿Cual es la autonomia de este vehiculo?");
						int tiempoRecarga = Generales.PideDatosNumericos("¿Cual es el tiempo en completar una carga completa?");
						int Nplazas = Generales.PideDatosNumericos("¿Cuantas plazas dispone este vehiculo?");
						String tipo = Generales.PideDatosString("");	
						
						vehiculo = new CochesElectricos(matricula, marca, modelo, color, km, fechaadquisicion, oficina,
															categoria, autonomia, tiempoRecarga, Nplazas, tipo);
						
					}
					else if (eleccionUsuario2 == 2)
					{
						int autonomia = Generales.PideDatosNumericos("¿Cual es la autonomia de este vehiculo?");
						int tiempoRecarga = Generales.PideDatosNumericos("¿Cual es el tiempo en completar una carga completa?");
						int cilindrada = Generales.PideDatosNumericos("¿Cual es la cilindrada de est motocicleta?");
						CarnetConducir CarnetRequerido = null;
						vehiculo = new Motocicletas(matricula, marca, modelo, color, km, fechaadquisicion, oficina,
													categoria, autonomia, tiempoRecarga, cilindrada, CarnetRequerido);
					}
					else
					{
						System.out.println("Introduzca un numero entre 1 y 2");
					}
					
				} while (eleccionUsuario2>1 && eleccionUsuario2<2);
			}
			else 
			{
				System.out.println("Introduzca un numero entre 1 y 2");
			}
		}	while (eleccionUsuario>1 && eleccionUsuario<2);
		return vehiculo;
	}
}





