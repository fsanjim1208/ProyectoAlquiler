package menus;

import java.io.Serializable;
import java.util.Scanner;

import entidades.*;
import excepciones.LongitudInvalidaException;
import mismetodos.MetodosGenerales;
import mismetodos.MetodosInterfazUsuario;

public class Menus {
	
	
	static Scanner lector =  new Scanner (System.in);
	
	
	//MENU PRINCIPAL
	
	/**
	 * Metodo que pinta el menu principal
	 * @param empresa Objeto del tipo Empresa necesario para los datos
	 * @throws LongitudInvalidaException
	 */
	public static void MenuPrincipal(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida = 0;
		
		MetodosGenerales.SubrayaString("EMPRESA ALQUILER", "·");
		System.out.println("1 - Mantenimiento");
		System.out.println("2 - Alquiler");
		System.out.println("3 - Listado y Consultas");
		System.out.println("4 - Salir");
			
		
		do 
		{
			opcionelegida= MetodosGenerales.PideDatosNumericos();
			
			if (opcionelegida==1)
			{
				MenuMantenimiento(empresa);
			}
			else if (opcionelegida==2)
			{
				MenuAlquileres(empresa);
			}
			else if (opcionelegida==3)
			{
				MenuListados(empresa);
			}
			else if (opcionelegida==4)
			{
				Empresa.GrabaEmpresa(empresa);
			}
			else
			{
				System.out.println("No valido");
			}
			
		} while ((opcionelegida==1) && (opcionelegida==2) && (opcionelegida==3));
	}

	
	//MENUS SECUNDARIOS 
	/**
	 * Metodo que pinta el menu para el mantenimiento de los datos
	 * añadir, modificar y eliminar
	 * @param empresa Objeto del tipo Empresa necesario para los datos
	 * @throws LongitudInvalidaException
	 */
	public static void MenuMantenimiento(Empresa empresa) throws LongitudInvalidaException 
	{
		int opcionelegida=0;
		
		
		MetodosGenerales.SubrayaString("MANTENIMIENTO", "*");
		System.out.println("1 - Oficinas");
		System.out.println("2 - Vehiculos");
		System.out.println("3 - Empleados");
		System.out.println("4 - Clientes");
		System.out.println("5 - Categorias");
		System.out.println("6 - Tipos de coches");
		System.out.println("7 - Salir");
		
		opcionelegida= MetodosGenerales.PideDatosNumericos();
		do 
		{
			if (opcionelegida==1)
			{
				MenuMantenimientoOficinas(empresa);
				
			}
			else if (opcionelegida==2)
			{
				MenuMantenimientoVehiculos(empresa);
			}
			else if (opcionelegida==3)
			{
				MenuMantenimientoEmpleados(empresa);	
			}
			else if (opcionelegida==4)
			{
				MenuMantenimientoClientes(empresa);
			}
			else if (opcionelegida==5)
			{
				MenuMantenimientoCategorias(empresa);
			}
			else if (opcionelegida==6)
			{
				MenuMantenimientoTipoCoches(empresa);
			}
			else if (opcionelegida==7)
			{
				MenuPrincipal(empresa);
			}
			else 
			{
				System.out.println("Valido");
			}
			
		} while (opcionelegida>5 || opcionelegida<1);
		
	}
	
	//MENU SECUNDARIO ALQUILERES
	/**
	 * Metodo que pinta el menu para los alquileres
	 * Alquilar y devolver coche alquilado
	 * @param empresa Objeto del tipo Empresa necesario para los datos
	 * @throws LongitudInvalidaException
	 */
	public static void MenuAlquileres(Empresa empresa) throws LongitudInvalidaException 
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("ALQUILER", "*");
		System.out.println("1 - Alquilar");
		System.out.println("2 - Devolver");
		System.out.println("3 - Salir");
		
		opcionelegida= MetodosGenerales.PideDatosNumericos();
		do 
		{
			if (opcionelegida==1)
			{
				empresa.AñadeAquileres(empresa);
			}
			else if (opcionelegida==2)
			{
				MetodosInterfazUsuario.MostrarAlquileresActivos(empresa);
				
				String codigoalquilerfinalizado=MetodosGenerales.PideDatosString("Introduza el codigo del alquiler que desea finalizar");
				
				empresa.getListaAlquileresActivos().remove(codigoalquilerfinalizado);
			}			
			else if (opcionelegida==3)
			{
				MenuPrincipal(empresa);
			}
			else
			{
				System.out.println("Valido");
			}
			
		} while (opcionelegida>3 || opcionelegida<1);
		
	}
	
	//MENU SECUNDARIO LISTADOS
	/**.
	 * Metodo que pinta el menu para los listados necesarios
	 * @param empresa Objeto del tipo Empresa necesario para los datos
	 * @throws LongitudInvalidaException
	 */
	public static void MenuListados(Empresa empresa) throws LongitudInvalidaException 
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("LISTADOS Y CONSULTAS", "*");
		System.out.println("1 - Listado de Alquileres por fecha");
		System.out.println("2 - Listado de alquileres de un determinado vehiculo");
		System.out.println("3 - Listado del stock de vehiculos de una oficina");
		System.out.println("4 - Listado de las categorias");
		System.out.println("5 - Listado de las Empleados");
		System.out.println("6 - Listado de las Vehiculos");
		System.out.println("7 - Listado de las Oficinas");
		System.out.println("8 - Listado de los Tipos de vehiculos");
		System.out.println("9 - Salir");
		
		do 
		{
			opcionelegida= MetodosGenerales.PideDatosNumericos();
		
		
			if (opcionelegida==1) 
			{
				MetodosInterfazUsuario.MostrarAlquileres(empresa);
				System.out.println("");
			}
			
			else if (opcionelegida==2)
			{
				System.out.println(empresa.getListaEmpleado().values());
			}
			
			else if (opcionelegida==3)
			{
				MetodosInterfazUsuario.MostrarOficinas(empresa);
				
				String codigooficina=MetodosGenerales.PideDatosString("Introduzca el codigo de la oficina de la que desea buscar");
				
				Oficina oficina2 = empresa.BuscaOficina(codigooficina);
				
				 for(int i = 0; i < empresa.getlistasVehiculosStockArrayList().size(); i++) 
			        {
			            if (empresa.getlistasVehiculosStockArrayList().get(i).getOficina()==oficina2)
			            {
			            	System.out.println(empresa.getlistasVehiculosStockArrayList().get(i));
			            }
			        }
			}
			else if (opcionelegida==4)
			{
				MetodosInterfazUsuario.MostrarCategorias(empresa);
				System.out.println("");
			}
			else if (opcionelegida==5)
			{
				MetodosInterfazUsuario.MostrarEmpleados(empresa);
				System.out.println("");
			}
			else if (opcionelegida==6)
			{
				
				System.out.println("VEhiculos");
				MetodosInterfazUsuario.MostrarVehiculos(empresa);
				System.out.println("");
				System.out.println("Stock");
				System.out.println("ArrayList Stock");
				 
				for(int i = 0; i < empresa.getlistasVehiculosStockArrayList().size(); i++) 
			        {
			         	System.out.println(empresa.getlistasVehiculosStockArrayList().get(i));
			        }
			}
			else if (opcionelegida==7)
			{
				MetodosInterfazUsuario.MostrarOficinas(empresa);
				System.out.println("");
			}
			else if (opcionelegida==8)
			{
				MetodosInterfazUsuario.MostrarTiposCoches(empresa);
				System.out.println("");
			}
			else if (opcionelegida==9)
			{
				MenuPrincipal(empresa);
			}
			else
			{
				System.out.println("No valido");
			}
			
		} while (opcionelegida>9 || opcionelegida<1);
		
	}

	//MENU TERCIARIO (DEVOLUCIONES)
	
	
	
	
	//MENUS TERCIRARIO (OFICINAS)
	
	/**
	 * Metodo que pinta el menu para el mantenimiento de los datos de una oficina
	 * añadir, modificar y eliminar
	 * @param empresa Objeto del tipo Empresa necesario para los datos
	 * @throws LongitudInvalidaException
	 */
	public static void MenuMantenimientoOficinas(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("OFICINA", "*");
		System.out.println("1 - Añade Oficinas");
		System.out.println("2 - Modifica Oficinas");
		System.out.println("3_- Elimina Oficinas");
		System.out.println("4 - Salir");
		
		opcionelegida=lector.nextInt();
		lector.nextLine();
		if (opcionelegida==1)
		{
			empresa.AñadeOficinas();
			
			System.out.println("¿Desea añadir mas oficinas?");
			System.out.println("1 - Si");
			System.out.println("2 - No");
			int respuesta= MetodosGenerales.PideDatosNumericos("");
			if (respuesta==1)
			{
				int respuesta1=0;
				do 
				{
					empresa.AñadeOficinas();
					System.out.println("¿Desea añadir otra oficina?");
					System.out.println("1 - Sí");
					System.out.println("2 - No");
					respuesta1=MetodosGenerales.PideDatosNumericos();
					
					
				}while (respuesta1==1);
			}
			else if (respuesta ==2)
			{
				MenuMantenimientoOficinas(empresa);
			}
				
		}
		else if (opcionelegida==2)
		{
			
		}
		else if (opcionelegida==3)
		{
			String codigo= MetodosGenerales.PideDatosString("¿Cual es el codigo de la oficina que desea eliminar?");
			Oficina oficina = empresa.BuscaOficina(codigo);
			empresa.EliminaOficina(oficina);
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento( empresa );
		}
	}
	
	//MENUS TERCIRARIO (VEHICULOS)
	
	/**
	 * Metodo que pinta el menu para el mantenimiento de los datos de un vehiculo
	 * añadir, modificar y eliminar
	 * @param empresa Objeto del tipo Empresa necesario para los datos
	 * @throws LongitudInvalidaException
	 */
	public static void MenuMantenimientoVehiculos(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("VEHICULOS", "*");
		System.out.println("1 - Añade Vehiculos");
		System.out.println("2 - Modifica Vehiculos");
		System.out.println("3 - Elimina Vehiculos");
	
		System.out.println("4 - Salir");
		System.out.println("5 - Añade Vehiculos a stock");
		
		opcionelegida=lector.nextInt();
		lector.nextLine();
		if (opcionelegida==1)
		{
			int respuesta=0;
			do 
			{
				empresa.AñadeVehiculos(empresa);
				System.out.println("¿Desea añadir otro vehiculo?");
				System.out.println("1 - Sí");
				System.out.println("2 - No");
				respuesta=MetodosGenerales.PideDatosNumericos();
				
				
			}while (respuesta==1);
		}
		else if (opcionelegida==2)
		{
			MetodosInterfazUsuario.MostrarVehiculos(empresa);
			empresa.ModificarVehiculos(empresa);
		}
		else if (opcionelegida==3)
		{
			String matricula= MetodosGenerales.PideDatosString("¿Cual es la matricula del vehiculo que desea eliminar?");
			Vehiculo vehiculo = empresa.BuscaVehiculo(matricula);
			empresa.EliminaVehiculos(vehiculo);
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento(empresa);
		}
		else if (opcionelegida==5) 
		{
			MetodosInterfazUsuario.MostrarVehiculos(empresa);
			
			String respuesta = MetodosGenerales.PideDatosString("Introduzca la matricula del vehiculo");
			
			empresa.AñadeVehiculosStockArrayList(empresa.getListaVehiculo().get(respuesta));
		}
	}
	
	//MENUS TERCIRARIO (EMPLEADOS)
	/**
	 * Metodo que pinta el menu para el mantenimiento de los datos de un Empleado
	 * añadir, modificar y eliminar
	 * @param empresa Objeto del tipo Empresa necesario para los datos
	 * @throws LongitudInvalidaException
	 */
	public static void MenuMantenimientoEmpleados(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		int opcionelegida2=0;
		
		MetodosGenerales.SubrayaString("EMPLEADOS", "*");
		System.out.println("1 - Añade Empleados");
		System.out.println("2 - Modifica Empleados");
		System.out.println("3 - Elimina Empleados");
		System.out.println("4 - Salir");
		
		opcionelegida=lector.nextInt();
		lector.nextLine();
		if (opcionelegida==1)
		{	
			empresa.AñadeEmpleado(empresa);
			
			System.out.println("¿Desea añadir otro empleado?");
			System.out.println("1 - Sí");
			System.out.println("2 - No");
			opcionelegida2= MetodosGenerales.PideDatosNumericos();
			if (opcionelegida2==1)
			{
				int respuesta=0;
				do 
				{
					empresa.AñadeEmpleado(empresa);
					System.out.println("¿Desea añadir otro empleado?");
					System.out.println("1 - Sí");
					System.out.println("2 - No");
					respuesta=MetodosGenerales.PideDatosNumericos();
					
					
				}while (respuesta==1);
			}
			else if (opcionelegida2==2)
			{
				MenuMantenimiento(empresa);
			}
		}
		else if (opcionelegida==2)
		{
			
		}
		else if (opcionelegida==3)
		{
			
			System.out.println("Nuesrtos empleados");
			MetodosInterfazUsuario.MostrarEmpleados(empresa);
			
			String dni= MetodosGenerales.PideDatosString("¿Cual es el Dni del empleado que desea eliminar?");
			Empleado empleado = empresa.BuscaEmpleado(dni);
			empresa.EliminaEmpleado(empleado);
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento(empresa);
		}
	}

	//MENUS TERCIRARIO (CLIENTES)

	/**
	 * Metodo que pinta el menu para el mantenimiento de los datos de un cliente
	 * añadir, modificar y eliminar
	 * @param empresa Objeto del tipo Empresa necesario para los datos
	 * @throws LongitudInvalidaException
	 */
	public static void MenuMantenimientoClientes(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("CLIENTES", "*");
		System.out.println("1 - Añade Clientes");
		System.out.println("2 - Modifica Clientes");
		System.out.println("3 - Elimina Clientes");
		System.out.println("4 - Salir");
		
		opcionelegida=lector.nextInt();
		lector.nextLine();
		if (opcionelegida==1)
		{
			int respuesta=0;
			do 
			{
				empresa.AñadeClientes();
				System.out.println("¿Desea añadir otra cliente?");
				System.out.println("1 - Sí");
				System.out.println("2 - No");
				respuesta=MetodosGenerales.PideDatosNumericos();
				
				
			}while (respuesta==1);
			
		}
		else if (opcionelegida==2)
		{
			
		}
		else if (opcionelegida==3)
		{
			String dni= MetodosGenerales.PideDatosString("¿Cual es el Dni del cliente que desea eliminar?");
			Cliente cliente = empresa.BuscaCliente(dni);
			empresa.EliminaCliente(cliente);
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento(empresa);
		}
	}
	
	//MENUS TERCIRARIO (CATEGORIAS)

	/**
	 * Metodo que pinta el menu para el mantenimiento de los datos de una categoria
	 * añadir, modificar y eliminar
	 * @param empresa Objeto del tipo Empresa necesario para los datos
	 * @throws LongitudInvalidaException
	 */
	public static void MenuMantenimientoCategorias(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("CATEGORIAS", "*");
		System.out.println("1 - Añade Categorias");
		System.out.println("2 - Modifica Categorias");
		System.out.println("3 - Elimina Categorias");
		System.out.println("4 - Salir");
		
		opcionelegida=lector.nextInt();
		lector.nextLine();
		if (opcionelegida==1)
		{
			int respuesta=0;
			do 
			{
				empresa.AñadeCategoria();
				System.out.println("¿Desea añadir otra categoria?");
				System.out.println("1 -Sí");
				System.out.println("2 - No");
				respuesta=MetodosGenerales.PideDatosNumericos();
				
				
			}while (respuesta==1);
		}
		else if (opcionelegida==2)
		{

			empresa.ModificarCategoria(empresa);
		}
		else if (opcionelegida==3)
		{
//			String codigo= MetodosGenerales.PideDatosString("¿Cual es el codigo de la categoria que desea eliminar?");
//			Categoria categoria = empresa.BuscaCategoria(codigo);
//			empresa.EliminaCategoria(categoria);
			empresa.getListaCategorias().clear();
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento(empresa);
		}
	}

	public static void MenuMantenimientoTipoCoches(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("Tipo de Coches", "*");
		System.out.println("1 - Añade Tipo de Coches");
		System.out.println("2 - Modifica Tipo de Coches");
		System.out.println("3 - Elimina Tipo de Coches");
		System.out.println("4 - Salir");
		
		opcionelegida=lector.nextInt();
		lector.nextLine();
		if (opcionelegida==1)
		{
			int respuesta=0;
			do 
			{
				empresa.AñadeTipoCoche();
				System.out.println("¿Desea añadir otra Tipo de Coches?");
				System.out.println("1 -Sí");
				System.out.println("2 - No");
				respuesta=MetodosGenerales.PideDatosNumericos();
				
				
			}while (respuesta==1);
		}
		else if (opcionelegida==2)
		{

			empresa.ModificarCategoria(empresa);
		}
		else if (opcionelegida==3)
		{
//			String codigo= MetodosGenerales.PideDatosString("¿Cual es el codigo de la categoria que desea eliminar?");
//			Categoria categoria = empresa.BuscaCategoria(codigo);
//			empresa.EliminaCategoria(categoria);
			empresa.getListaCategorias().clear();
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento(empresa);
		}
	}
	}
