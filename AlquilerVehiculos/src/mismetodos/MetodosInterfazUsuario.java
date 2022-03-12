package mismetodos;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Map.Entry;

import entidades.*;
import excepciones.LongitudInvalidaException;
import metodos_personales.*;

public class MetodosInterfazUsuario {
	
	/**
	 * Metodo que pide todos los datos necesarios para crear un Objeto de tipo Empresa
	 * @return Nos devuelve un objeto de tipo Empleado
	 */
	public static Empresa PideDatosEmpresa() 
	{
		Empresa empresa = null;

			String nombre=MetodosGenerales.PideDatosString("Introduce el nombre de la empresa");
			String nif=MetodosGenerales.PideDatosString("Introduce el NIF de la empresa");
			
			
			empresa = new Empresa(nombre, nif);
			

		return empresa;
	}
	
	/**
	 * Metodo que pide todos los datos necesarios para crear un Objeto de tipo Gregorian Calendar (fecha)
	 * @param mensajedia Mensaje que muestra al pedir el dia de la fecha
	 * @param mensajemes Mensaje que muestra al pedir el mes de la fecha
	 * @param mensajeaño Mensaje que muestra al pedir el año de la fecha
	 * @return Nos devuelve un objeto de tipo Gregorian Calendar (fecha) con el formato dia, mes, año
	 */
	public static GregorianCalendar PideDatosFecha(String mensajedia, String mensajemes, String mensajeaño)
	{
		GregorianCalendar fecha = null;
		int dia = MetodosGenerales.PideDatosNumericos(mensajedia);
		int mes = MetodosGenerales.PideDatosNumericos(mensajemes);
		int año = MetodosGenerales.PideDatosNumericos(mensajeaño);
		
		fecha = new GregorianCalendar(dia, mes, año);
		
		return fecha;
	}
	
	/**
	 * Metodo que pide todos los datos necesarios para crear un Objeto de tipo Empresa
	 * @param empresa elemento del objeto Empresa
	 * @return Nos devuelve un objeto de tipo Empresa
	 * @throws LongitudInvalidaException
	 */
	public static Alquiler PideDatosAlquiler(Empresa empresa) throws LongitudInvalidaException 
	{
		Alquiler alquiler=null;
		
		MetodosGenerales.SubrayaString("Nuestros empleados", "=");
		MostrarEmpleados(empresa);		
		String Dni_emple = MetodosGenerales.PideDatosString("Introduzca el Dni del empleado");
		Empleado empleado=empresa.getListaEmpleado().get(Dni_emple);
		
		
		String codigo = MetodosGenerales.PideDatosString("Introduce el codigo del alquiler");

		
		MetodosGenerales.SubrayaString("Nuestros Vehiculos disponibles", "=");
		MostrarVehiculos(empresa);
		
		String matricula = MetodosGenerales.PideDatosString("Introduzca la matricula deseada");
		Vehiculo vehiculo_alquilado=empresa.getListaVehiculo().get(matricula);		
		MetodosGenerales.SubrayaString("Nuestros Oficinas", "=");
		MostrarOficinas(empresa);
		
		String codigooficina = MetodosGenerales.PideDatosString("¿Donde desea alquilar su vehiculo?");
		Oficina lugar_alquiler=empresa.getListaOficinas().get(codigooficina);

		
		GregorianCalendar fecha_alquila = PideDatosFecha("Introduzca el dia que dese alquilar el vehiculo","Introduzca el mes que dese alquilar el vehiculo","Introduzca el año que dese alquilar el vehiculo,");
		GregorianCalendar fecha_devuelve = PideDatosFecha("Introduzca el dia que dese devolver el vehiculo","Introduzca el mes que dese devolver el vehiculo","Introduzca el año que dese devolver el vehiculo,");
		
		
		Cliente cliente=PideDatosCliente();
		empresa.AñadeClientes(cliente);
		alquiler= new Alquiler(codigo, cliente, empleado, vehiculo_alquilado, lugar_alquiler, fecha_alquila, fecha_devuelve);
		
		return alquiler;
	}

	/**
	 * Metodo que pide todos los datos necesarios para crear un Objeto de tipo Cliente
	 * @return Nos devuelve un objeto de tipo Cliente
	 * @throws LongitudInvalidaException
	 */
	public static Cliente PideDatosCliente() throws LongitudInvalidaException
	{
		Cliente cliente= null;
		
		String Nombre = MetodosGenerales.PideDatosString("Introduzca el nombre del cliente");
		String Ape1 = MetodosGenerales.PideDatosString("Introduzca el primer apellido del cliente");
		String Ape2 = MetodosGenerales.PideDatosString("Introduzca el segundo apellido del cliente");
		String Dni = MetodosGenerales.PideDatosString("Introduzca su Dni");
		
		CarnetConducir tipoCarnet = PideDatosCarnet();
		int ntarjetaCliente = MetodosGenerales.PideDatosNumericos("Introduzca el numero de la tarjeta de cliente");
		
		cliente = new Cliente(Nombre, Ape1,Ape2, Dni, tipoCarnet, ntarjetaCliente);
		
		return cliente;
	}
	
	/**
	 * Metodo que pide todos los datos necesarios para crear un Objeto de tipo CarnetConducir
	 * @return Nos devuelve un objeto de tipo CarnetConducir
	 */
	public static CarnetConducir PideDatosCarnet()
	{
		CarnetConducir carnet = null;
		
		String letra = MetodosGenerales.PideDatosString("Introduzca la letra del Carnet (A - B - C)");
		String Descripcion = MetodosGenerales.PideDatosString("Introduzca descripcion");
		
		carnet = new CarnetConducir(letra, Descripcion);
		
		return carnet;
	}
	
	/**
	 * Metodo que pide todos los datos para crear un Objeto de tipo Empleado
	 * @param empresa elemento del objeto Empresa
	 * @return Nos devuelve un objeto de tipo Empleado
	 */
	public static Empleado PideDatosEmpleado(Empresa empresa)
	{
		Empleado empleado= null;
	
		String Nombre = MetodosGenerales.PideDatosString("Introduzca el nombre del empleado");
		String Ape1 = MetodosGenerales.PideDatosString("Introduzca el primer apellido del empleado");
		String Ape2 = MetodosGenerales.PideDatosString("Introduzca el segundo apellido del empleado");
		String Dni= MetodosGenerales.PideDatosString("Introduzca su Dni");
		System.out.println("Introduzca la fecha de alta");
		GregorianCalendar fechaAltEmpleado = PideDatosFecha("dia","mes","año");
		
		MetodosGenerales.SubrayaString("Estas son nuestras Oficinas", "=");
		MostrarOficinas(empresa);
		
		String codigoOficina= MetodosGenerales.PideDatosString("Introduzca el codigo de la oficina, si no existe en la lista anterior, introduzca el codigo de la nueva oficina");
		
		
		Oficina OficinaEmpleado=null;
			
		if (empresa.getListaOficinas().get(codigoOficina)==null)	
		{
			empresa.AñadeOficinas(empresa.getListaOficinas().get(codigoOficina));
		}
		else
		{
			OficinaEmpleado=empresa.getListaOficinas().get(codigoOficina);
		}
			
		
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
	
	/**
	 * Metodo que pide todos los datos para crear un Objeto de tipo Empleado
	 * @return Nos devuelve un objeto de tipo Categoria 
	 */
	public static Categoria PideDatosCategoria()
	{
		Categoria categoria = null;
		
		String Codigo = MetodosGenerales.PideDatosString("Codigo de la categoria");
		String Descripcion = MetodosGenerales.PideDatosString("Descripcion de la categoria");
		int recargo = MetodosGenerales.PideDatosNumericos("Introduzca el recargo");
		
		categoria = new Categoria(Codigo, Descripcion, recargo);
		
		return categoria;
	}
	
	/**
	 * Metodo que pide todos los datos para crear un Objeto de tipo Categoria
	 * @param Codigo String unica para cada Categoria
	 * @return Nos devuelve un objeto de tipo Categoria 
	 */
	public static Categoria PideDatosCategoria(String codigo)
	{
		Categoria categoria = null;
		
		String Codigo = codigo;
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
	
	/**
	 * Metodo que pide todos los datos para crear un Objeto de tipo Oficina
	 * @param Codigo String unica para cada oficina
	 * @return Nos devuelve un objeto de tipo Oficina
	 */
	public static Oficina PideDatosOficina(String Codigo)
	{
		Oficina oficina=null;

		String codigo = Codigo;
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
		
		oficina= new Oficina(codigo, Descripcion, Localidad, Provincia, OficinaAeropuerto);
		
		return oficina;
	}

	/**
	 * Metodo que pide todos los datos para crear un Objeto de tipo Vehiculo
	 * @param empresa elemento del objeto Empresa
	 * @return Nos da un objeto de tipo Vehiculo
	 */
	public static Vehiculo PideDatosVehiculo(Empresa empresa)
	{
		
		Vehiculo vehiculo = null;
		
		String matricula = MetodosGenerales.PideDatosString("Introduzca la matricula del vehiculo");
		String marca = MetodosGenerales.PideDatosString("Introduzca la marca");
		String modelo = MetodosGenerales.PideDatosString("Introduza el modelo");
		String color = MetodosGenerales.PideDatosString("¿De que color es?");
		int km = MetodosGenerales.PideDatosNumericos("¿Cuantos KM tiene el coche?");
		GregorianCalendar fechaadquisicion = PideDatosFecha("introduzca el dia de adquisicion","Introduzca el mes de adquisicion","Introduzca el año de adquision");
		
		MetodosGenerales.SubrayaString("Estas son nuestras Oficinas", "=");
		MostrarOficinas(empresa);
		
		String codigoOficina= MetodosGenerales.PideDatosString("Introduzca el codigo de la oficina, si no existe en la lista anterior, introduzca el codigo de la nueva oficina");
		
		
		Oficina oficina=null;
			
		if (empresa.getListaOficinas().get(codigoOficina)==null)	
		{
			empresa.AñadeOficinas(empresa.getListaOficinas().get(codigoOficina));
		}
		else
		{
			oficina=empresa.getListaOficinas().get(codigoOficina);
		}
			
		
		MetodosGenerales.SubrayaString("Estas son las categorias", "=");
		MostrarCategorias(empresa);
		
		String codigoCategoria= MetodosGenerales.PideDatosString("Introduzca el codigo de la Categoria");
		
		
		Categoria categoria=null;
			
		if (empresa.getListaCategorias().get(codigoCategoria)==null)	
		{
			empresa.AñadeCategoria(empresa.getListaCategorias().get(codigoCategoria));
		}
		else
		{
			categoria=empresa.getListaCategorias().get(codigoCategoria);
		}
			
		
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
						String tipo="";
						int respuesta=0;
						
						MostrarTiposCoches(empresa);
						respuesta = MetodosGenerales.PideDatosNumericos("¿indica el numero asociado al tipo de coche introducido?");
						
						if (respuesta==1)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==2)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==3)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==4)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==5)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==6)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==7)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==8)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else
						{
							System.out.println("Valor introducido no valido");
						}
						
						
						
						vehiculo = new CochesCombustion(matricula, marca, modelo, color, km, fechaadquisicion,
														oficina, categoria, nivelEmisiones, Nplazas, tipo);
						
					}
					else if (eleccionUsuario2 == 2)
					{
						String consumo = MetodosGenerales.PideDatosString("¿Cual es el consumo promedio de este coche?");
						int potencia = MetodosGenerales.PideDatosNumericos("¿Que potencia dispone esta furgoneta?");
						String nivelEmisiones = MetodosGenerales.PideDatosString("¿Cual es el nivel de emision de gases promedio de este coche?");
						int CapacidadCarga = MetodosGenerales.PideDatosNumericos("¿Cual es la capacidad de carga?");;
						CarnetConducir CarnetRequerido = PideDatosCarnet();
						
						vehiculo = new Furgonetas(matricula, marca, modelo, color, km, fechaadquisicion, oficina,
													categoria, nivelEmisiones, CapacidadCarga, CarnetRequerido);
						
					}
					else
					{
						System.out.println("Introduzca un numero entre 1 y 2");
					}
					
				} while (eleccionUsuario2<1 || eleccionUsuario2>2);
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
						String tipo="";
						int respuesta=0;
						
						MostrarTiposCoches(empresa);
						respuesta = MetodosGenerales.PideDatosNumericos("¿indica el numero asociado al tipo de coche introducido?");
						
						if (respuesta==1)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==2)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==3)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==4)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==5)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==6)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==7)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else if(respuesta==8)
						{
							tipo=empresa.getlistasTipodeCoche().get(respuesta-1);
						}
						else
						{
							System.out.println("Valor introducido no valido");
						}
						
						vehiculo = new CochesElectricos(matricula, marca, modelo, color, km, fechaadquisicion, oficina,
															categoria, autonomia, tiempoRecarga, Nplazas, tipo);
						
					}
					else if (eleccionUsuario2 == 2)
					{
						int autonomia = MetodosGenerales.PideDatosNumericos("¿Cual es la autonomia de este vehiculo?");
						int tiempoRecarga = MetodosGenerales.PideDatosNumericos("¿Cual es el tiempo en completar una carga completa?");
						int cilindrada = MetodosGenerales.PideDatosNumericos("¿Cual es la cilindrada de est motocicleta?");
						CarnetConducir CarnetRequerido = PideDatosCarnet();
						
						vehiculo = new Motocicletas(matricula, marca, modelo, color, km, fechaadquisicion, oficina,
													categoria, autonomia, tiempoRecarga, cilindrada, CarnetRequerido);
					}
					else
					{
						System.out.println("Introduzca un numero entre 1 y 2");
					}
					
				} while (eleccionUsuario2<1 || eleccionUsuario2>2);
			}
			else 
			{
				System.out.println("Introduzca un numero entre 1 y 2");
			}
		}	 while (eleccionUsuario<1 || eleccionUsuario>2);
		return vehiculo;
	}
	

	
	
	
	
	
	
	/**
	 * Metodo que muestra todoso los elementos que hay dentro del TreeMap de Empleados
	 * @param empresa elemento del objeto Empresa
	 */
	public static void MostrarEmpleados (Empresa empresa)
	{
		MetodosGenerales.SubrayaString("Nuestros Empleados", "*");
		for (Entry<String, Empleado> item:empresa.getListaEmpleado().entrySet())
		{
			Empleado empleado=item.getValue();
			System.out.println(empleado);
		}
	}
	
	/**
	 * Metodo que muestra todoso los elementos que hay dentro del TreeMap de Clientes
	 * @param empresa elemento del objeto Empresa
	 */
	public static void MostrarClientes (Empresa empresa)
	{
		MetodosGenerales.SubrayaString("Nuestros Clientes", "*");
		for (Entry<String, Cliente> item:empresa.getListaCliente().entrySet())
		{
			Cliente cliente=item.getValue();
			System.out.println(cliente);
		}
	}
	
	/**
	 * Metodo que muestra todoso los elementos que hay dentro del TreeMap de Vehiculos
	 * @param empresa elemento del objeto Empresa
	 */
	public static void MostrarVehiculos (Empresa empresa)
	{
		MetodosGenerales.SubrayaString("Nuestros vehiculos", "*");
		
		for (Entry<String, Vehiculo> item:empresa.getListaVehiculo().entrySet())
		{
			Vehiculo vehiculo=item.getValue();
			System.out.println(vehiculo);
		} 
	}
	
	/**
	 * Metodo que muestra todoso los elementos que hay dentro del TreeMap de Categorias
	 * @param empresa elemento del objeto Empresa
	 */
	public static void MostrarCategorias (Empresa empresa)
	{
		MetodosGenerales.SubrayaString("Nuestras Categorias", "*");
		for (Entry<String, Categoria> item:empresa.getListaCategorias().entrySet())
		{
			Categoria categoria=item.getValue();
			System.out.println(categoria);
		}
	}
	
	/**
	 * Metodo que muestra todos los elementos que hay dentro del TreeMap de Oficinas
	 * @param empresa elemento del objeto Empresa
	 */
	public static void MostrarOficinas (Empresa empresa)
	{
		MetodosGenerales.SubrayaString("Nuestras Oficinas", "*");
		for (Entry<String, Oficina> item:empresa.getListaOficinas().entrySet())
		{
			Oficina oficina=item.getValue();
			System.out.println(oficina);
		}
	}
	
	/**
	 * Metodo que muestra todos los elementos que hay dentro del TreeMap de alquileres
	 * @param empresa elemento del objeto Empresa
	 */
	public static void MostrarAlquileres (Empresa empresa)
	{
		MetodosGenerales.SubrayaString("Nuestros alquileres", "*");
		for (Entry<String, Alquiler> item:empresa.getListaAlquileres().entrySet())
		{
			Alquiler alquiler=item.getValue();
			System.out.println(alquiler);
		}
	}
	
	public static void MostrarTiposCoches (Empresa empresa)
	{
		MetodosGenerales.SubrayaString("Tipos de Vehiculos", "*");
        for(int i = 0; i < empresa.getlistasTipodeCoche().size(); i++) 
        {
            System.out.println((i+1)+" - "+empresa.getlistasTipodeCoche().get(i));
        }
	}
}





