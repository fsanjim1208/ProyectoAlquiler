package mismetodos;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Map.Entry;

import entidades.*;
import excepciones.LongitudInvalidaException;
import metodos_personales.*;

public class MetodosInterfazUsuario {
	
	
	public static Empresa PideDatosEmpresa() 
	{
		Empresa empresa = null;

			String nombre=MetodosGenerales.PideDatosString("Introduce el nombre de la empresa");
			String nif=MetodosGenerales.PideDatosString("Introduce el NIF de la empresa");
			
			
			empresa = new Empresa(nombre, nif);
			

		return empresa;
	}
	
	public static GregorianCalendar PideDatosFecha(String mensajedia, String mensajemes, String mensajeaño)
	{
		GregorianCalendar fecha = null;
		int dia = MetodosGenerales.PideDatosNumericos(mensajedia);
		int mes = MetodosGenerales.PideDatosNumericos(mensajemes);
		int año = MetodosGenerales.PideDatosNumericos(mensajeaño);
		
		fecha = new GregorianCalendar(dia, mes, año);
		
		return fecha;
	}
	
	public static Alquiler PideDatosAlquiler() throws LongitudInvalidaException 
	{
		Alquiler alquiler=null;
		String codigo = MetodosGenerales.PideDatosString("Introduce el codigo del alquiler");
		Cliente cliente = PideDatosCliente();
		Empleado empleado = PideDatosEmpleado();
		Vehiculo vehiculo_alqiuilado = PideDatosVehiculo();
		Oficina lugar_alquiler = PideDatosOficina();
		GregorianCalendar fecha_alquila = PideDatosFecha("Introduzca el dia que dese alquilar el vehiculo","Introduzca el mes que dese alquilar el vehiculo","Introduzca el año que dese alquilar el vehiculo,");
		GregorianCalendar fecha_devuelve = PideDatosFecha("Introduzca el dia que dese devolver el vehiculo","Introduzca el mes que dese devolver el vehiculo","Introduzca el año que dese devolver el vehiculo,");
		
		alquiler= new Alquiler(codigo, cliente, empleado, vehiculo_alqiuilado, lugar_alquiler, fecha_alquila, fecha_devuelve);
		
		return null;
	}

	public static Cliente PideDatosCliente() throws LongitudInvalidaException
	{
		Cliente cliente= null;
		
		String Nombre = MetodosGenerales.PideDatosString("Introduzca el nombre del empleado");
		String Ape1 = MetodosGenerales.PideDatosString("Introduzca el primer apellido del empleado");
		String Ape2 = MetodosGenerales.PideDatosString("Introduzca el segundo apellido del empleado");
		String Dni = MetodosGenerales.PideDatosString("Introduzca su Dni");
		
		CarnetConducir tipoCarnet = PideDatosCarnet();
		int ntarjetaCliente = MetodosGenerales.PideDatosNumericos("Introduzca el numero de la tarjeta de cliente");
		
		cliente = new Cliente(Nombre, Ape1,Ape2, Dni, tipoCarnet, ntarjetaCliente);
		
		return cliente;
	}
	
	public static CarnetConducir PideDatosCarnet()
	{
		CarnetConducir carnet = null;
		
		String letra = MetodosGenerales.PideDatosString("Introduzca la letra del Carnetk");
		String Descripcion = MetodosGenerales.PideDatosString("Introduzca su Dni");
		
		carnet = new CarnetConducir(letra, Descripcion);
		
		return carnet;
	}
	
	public static Empleado PideDatosEmpleado()
	{
		Empleado empleado= null;
	
		String Nombre = MetodosGenerales.PideDatosString("Introduzca el nombre del empleado");
		String Ape1 = MetodosGenerales.PideDatosString("Introduzca el primer apellido del empleado");
		String Ape2 = MetodosGenerales.PideDatosString("Introduzca el segundo apellido del empleado");
		String Dni= MetodosGenerales.PideDatosString("Introduzca su Dni");
		System.out.println("Introduzca la fecha de alta");
		GregorianCalendar fechaAltEmpleado = PideDatosFecha("dia","mes","año");
		
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
		
		String Codigo = MetodosGenerales.PideDatosString("Codigo de la categoria");
		String Descripcion = MetodosGenerales.PideDatosString("Descripcion de la categoria");
		int recargo = MetodosGenerales.PideDatosNumericos("Introduzca el recargo");
		
		categoria = new Categoria(Codigo, Descripcion, recargo);
		
		return categoria;
	}
	
	public static Oficina PideDatosOficina()
	{
		Oficina oficina=null;

		String Codigo = MetodosGenerales.PideDatosString("Introduce el Código de la oficina");
		String Descripcion= MetodosGenerales.PideDatosString("Introduzca una pequeña descripcion de su oficina");
		String Localidad= MetodosGenerales.PideDatosString("¿Dónde se encuentra la Oficina");
		String Provincia=MetodosGenerales.PideDatosString("¿A que provincia pertenece?");
		int opcion=0;
		Boolean OficinaAeropuerto = false;
		System.out.println("Su oficina se encuentra en el aeropuerto de su ciudad");
		System.out.println("1-Sí");
		System.out.println("2-no");
		opcion=MetodosGenerales.PideDatosNumericos("");
		if (opcion==1)
		{
			OficinaAeropuerto=true;
		}
		else if(opcion==2)
		{
			OficinaAeropuerto=false;
		}
		else
		{
			System.out.println("Eleccion erronea");
		}
		
		oficina= new Oficina(Codigo, Descripcion, Localidad, Provincia, OficinaAeropuerto);
		
		return oficina;
	}

	
	public static Vehiculo PideDatosVehiculo()
	{
		
		Vehiculo vehiculo = null;
		
		String matricula = MetodosGenerales.PideDatosString("Introduzca la matricula del vehiculo");
		String marca = MetodosGenerales.PideDatosString("Introduzca la marca");
		String modelo = MetodosGenerales.PideDatosString("Introduza el modelo");
		String color = MetodosGenerales.PideDatosString("¿De que color es?");
		int km = MetodosGenerales.PideDatosNumericos("¿Cuantos KM tiene el coche?");
		GregorianCalendar fechaadquisicion = PideDatosFecha("introduzca el dia de adquisicion","Introduzca el mes de adquisicion","Introduzca el año de adquision");
		Oficina oficina= PideDatosOficina();
		Categoria categoria = PideDatosCategoria();
		
		int eleccionUsuario;
		int eleccionUsuario2;
		
		do 
		{
			System.out.println("¿Que tipo de motor es?");
			System.out.println("1-Combustion");
			System.out.println("2-Electrico");
			eleccionUsuario = MetodosGenerales.PideDatosNumericos("");
				
			if (eleccionUsuario == 1)
			{

				do
				{
					MetodosGenerales.SubrayaString("COMBUSTIÓN", "_");
					System.out.println("¿Que tipo de vehiculo es?");
					System.out.println("1-Coche");
					System.out.println("2-Furgoneta");
					eleccionUsuario2 = MetodosGenerales.PideDatosNumericos("");
					
					if (eleccionUsuario2 == 1)
					{
						String consumo = MetodosGenerales.PideDatosString("¿Cual es el consumo promedio de este coche?");
						int potencia = MetodosGenerales.PideDatosNumericos("¿Que potencia dispone este coche?");
						String nivelEmisiones = MetodosGenerales.PideDatosString("¿Cual es el nivel de emision de gases promedio de este coche?");
						int Nplazas = MetodosGenerales.PideDatosNumericos("¿Cuantas plazas tiene este coche?");
						String tipo = MetodosGenerales.PideDatosString("¿Que tipo de coche es?");
						
						vehiculo = new CochesCombustion(matricula, marca, modelo, color, km, fechaadquisicion,
														oficina, categoria, nivelEmisiones, Nplazas, tipo);
						
					}
					else if (eleccionUsuario2 == 2)
					{
						String consumo = MetodosGenerales.PideDatosString("¿Cual es el consumo promedio de este coche?");
						int potencia = MetodosGenerales.PideDatosNumericos("¿Que potencia dispone esta furgoneta?");
						String nivelEmisiones = MetodosGenerales.PideDatosString("¿Cual es el nivel de emision de gases promedio de este coche?");
						int CapacidadCarga = MetodosGenerales.PideDatosNumericos("¿Que potencia dispone esta furgoneta?");;
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
					MetodosGenerales.SubrayaString("ELECTRICO", "_");
					System.out.println("¿Que tipo de vehiculo es?");
					System.out.println("1-Coche");
					System.out.println("2-Motociclieta");
					eleccionUsuario2 = MetodosGenerales.PideDatosNumericos("");
					
					if (eleccionUsuario2 == 1)
					{
						int autonomia = MetodosGenerales.PideDatosNumericos("¿Cual es la autonomia de este vehiculo?");
						int tiempoRecarga = MetodosGenerales.PideDatosNumericos("¿Cual es el tiempo en completar una carga completa?");
						int Nplazas = MetodosGenerales.PideDatosNumericos("¿Cuantas plazas dispone este vehiculo?");
						String tipo = MetodosGenerales.PideDatosString("");	
						
						vehiculo = new CochesElectricos(matricula, marca, modelo, color, km, fechaadquisicion, oficina,
															categoria, autonomia, tiempoRecarga, Nplazas, tipo);
						
					}
					else if (eleccionUsuario2 == 2)
					{
						int autonomia = MetodosGenerales.PideDatosNumericos("¿Cual es la autonomia de este vehiculo?");
						int tiempoRecarga = MetodosGenerales.PideDatosNumericos("¿Cual es el tiempo en completar una carga completa?");
						int cilindrada = MetodosGenerales.PideDatosNumericos("¿Cual es la cilindrada de est motocicleta?");
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
	
	public static void MostrarEmpleados (Empresa empresa)
	{
		for (Entry<String, Empleado> item:empresa.getListaEmpleado().entrySet())
		{
			Empleado empleado=item.getValue();
			System.out.println(empleado);
		}
	}
	
	public static void MostrarClientes (Empresa empresa)
	{
		for (Entry<String, Cliente> item:empresa.getListaCliente().entrySet())
		{
			Cliente cliente=item.getValue();
			System.out.println(cliente);
		}
	}
	
	public static void MostrarVehiculos (Empresa empresa)
	{
		for (Entry<String, Vehiculo> item:empresa.getListaVehiculo().entrySet())
		{
			Vehiculo vehiculo=item.getValue();
			System.out.println(vehiculo);
		}
	}
	
	public static void MostrarCategorias (Empresa empresa)
	{
		for (Entry<String, Categoria> item:empresa.getListaCategorias().entrySet())
		{
			Categoria categoria=item.getValue();
			System.out.println(categoria);
		}
	}
	
	public static void MostrarOficinas (Empresa empresa)
	{
		for (Entry<String, Oficina> item:empresa.getListaOficinas().entrySet())
		{
			Oficina oficina=item.getValue();
			System.out.println(oficina);
		}
	}
}





