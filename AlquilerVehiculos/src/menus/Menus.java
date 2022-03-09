package menus;

import java.io.Serializable;
import java.util.Scanner;

import entidades.*;
import excepciones.LongitudInvalidaException;
import mismetodos.MetodosGenerales;
import mismetodos.MetodosInterfazUsuario;

public class Menus {
	
	
	static Scanner lector =  new Scanner (System.in);
	
	public static void MenuPrincipal(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida = 0;
		
		MetodosGenerales.SubrayaString("EMPRESA ALQUILER", "*");
		System.out.println("1_Mantenimiento");
		System.out.println("2_Alquiler");
		System.out.println("3_Listado y Consultas");
		System.out.println("4_Salir");
			
		opcionelegida= lector.nextInt();
//		lector.next();
		do 
		{
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
			
		} while (opcionelegida!=4);
	}

	
	
	
	public static void MenuMantenimiento(Empresa empresa) throws LongitudInvalidaException 
	{
		int opcionelegida=0;
		
		
		MetodosGenerales.SubrayaString("MANTENIMIENTO", "*");
		System.out.println("1_Oficinas");
		System.out.println("2_Vehiculos");
		System.out.println("3_Empleados");
		System.out.println("4_Clientes");
		System.out.println("5_Categorias");
		System.out.println("6_Salir");
		
		opcionelegida= lector.nextInt();
//		lector.next();
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
				MenuPrincipal(empresa);
			}
			else 
			{
				System.out.println("Valido");
			}
			
		} while (opcionelegida>5 || opcionelegida<1);
		
	}
	public static void MenuMantenimientoOficinas(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("OFICINA", "*");
		System.out.println("1_Añade Oficinas");
		System.out.println("2_Modifica Oficinas");
		System.out.println("3_Elimina Oficinas");
		System.out.println("4_Salir");
		
		opcionelegida=lector.nextInt();
		if (opcionelegida==1)
		{
			empresa.AñadeOficinas();
			
			System.out.println("¿Desea añadir mas oficinas?");
			System.out.println("1_Si");
			System.out.println("2_No");
			int respuesta= MetodosGenerales.PideDatosNumericos("");
			if (respuesta==1)
			{
				int respuesta1=0;
				do 
				{
					empresa.AñadeOficinas();
					System.out.println("¿Desea añadir otra oficina?");
					System.out.println("1-Sí");
					System.out.println("2-No");
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
	
	public static void MenuMantenimientoVehiculos(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("VEHICULOS", "*");
		System.out.println("1_Añade Vehiculos");
		System.out.println("2_Modifica Vehiculos");
		System.out.println("3_Elimina Vehiculos");
		System.out.println("4_Salir");
		
		opcionelegida=lector.nextInt();
		if (opcionelegida==1)
		{
			int respuesta=0;
			do 
			{
				empresa.AñadeVehiculos();
				System.out.println("¿Desea añadir otro vehiculo?");
				System.out.println("1-Sí");
				System.out.println("2-No");
				respuesta=MetodosGenerales.PideDatosNumericos();
				
				
			}while (respuesta==1);
		}
		else if (opcionelegida==2)
		{
			
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
	}
	
	
	public static void MenuMantenimientoEmpleados(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		int opcionelegida2=0;
		
		MetodosGenerales.SubrayaString("EMPLEADOS", "*");
		System.out.println("1_Añade Empleados");
		System.out.println("2_Modifica Empleados");
		System.out.println("3_Elimina Empleados");
		System.out.println("4_Salir");
		
		opcionelegida=lector.nextInt();
		if (opcionelegida==1)
		{	
			empresa.AñadeEmpleado();
			
			System.out.println("¿Desea añadir otro empleado?");
			System.out.println("1-Sí");
			System.out.println("2-No");
			opcionelegida2= MetodosGenerales.PideDatosNumericos();
			if (opcionelegida2==1)
			{
				int respuesta=0;
				do 
				{
					empresa.AñadeEmpleado();
					System.out.println("¿Desea añadir otro empleado?");
					System.out.println("1-Sí");
					System.out.println("2-No");
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
			String dni= MetodosGenerales.PideDatosString("¿Cual es el Dni del empleado que desea eliminar?");
			Empleado empleado = empresa.BuscaEmpleado(dni);
			empresa.EliminaEmpleado(empleado);
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento(empresa);
		}
	}


	public static void MenuMantenimientoClientes(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("CLIENTES", "*");
		System.out.println("1_Añade Clientes");
		System.out.println("2_Modifica Clientes");
		System.out.println("3_Elimina Clientes");
		System.out.println("4_Salir");
		
		opcionelegida=lector.nextInt();
		if (opcionelegida==1)
		{
			int respuesta=0;
			do 
			{
				empresa.AñadeClientes();
				System.out.println("¿Desea añadir otra cliente?");
				System.out.println("1-Sí");
				System.out.println("2-No");
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

	public static void MenuMantenimientoCategorias(Empresa empresa) throws LongitudInvalidaException
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("CATEGORIAS", "*");
		System.out.println("1_Añade Categorias");
		System.out.println("2_Modifica Categorias");
		System.out.println("3_Elimina Categorias");
		System.out.println("4_Salir");
		
		opcionelegida=lector.nextInt();
		if (opcionelegida==1)
		{
			int respuesta=0;
			do 
			{
				empresa.AñadeCategoria();
				System.out.println("¿Desea añadir otra categoria?");
				System.out.println("1-Sí");
				System.out.println("2-No");
				respuesta=MetodosGenerales.PideDatosNumericos();
				
				
			}while (respuesta==1);
		}
		else if (opcionelegida==2)
		{
			
		}
		else if (opcionelegida==3)
		{
			String codigo= MetodosGenerales.PideDatosString("¿Cual es el codigo de la categoria que desea eliminar?");
			Categoria categoria = empresa.BuscaCategoria(codigo);
			empresa.EliminaCategoria(categoria);
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento(empresa);
		}
	}

	public static void MenuAlquileres(Empresa empresa) throws LongitudInvalidaException 
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("ALQUILER", "*");
		System.out.println("1_Alquilar");
		System.out.println("2_Devolver");
		System.out.println("3_Salir");
		
		opcionelegida= lector.nextInt();
//		lector.next();
		do 
		{
			if (opcionelegida==1)
			{
				
			}
			else if (opcionelegida==2)
			{
				
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
	
	
	
	public static void MenuListados(Empresa empresa) throws LongitudInvalidaException 
	{
		int opcionelegida=0;
		
		MetodosGenerales.SubrayaString("LISTADOS Y CONSULTAS", "*");
		System.out.println("1_Listado de Alquileres por fecha");
		System.out.println("2_Listado de alquileres de un determinado vehiculo");
		System.out.println("3_Listado del stock de vehiculos de una oficina");
		System.out.println("4_Listado de las categorias");
		System.out.println("5_Listado de las Empleados");
		System.out.println("6_Listado de las Vehiculos");
		System.out.println("7_Listado de las Oficinas");
		System.out.println("8_Salir");
		
		opcionelegida= lector.nextInt();
//		lector.next();
		do 
		{
			if (opcionelegida==1) 
			{
				System.out.println(empresa.getListaEmpleado().values());
				
			}
			else if (opcionelegida==2)
			{
				
			}
			else if (opcionelegida==3)
			{
				
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
				MetodosInterfazUsuario.MostrarVehiculos(empresa);
				System.out.println("");
			}
			else if (opcionelegida==7)
			{
				MetodosInterfazUsuario.MostrarOficinas(empresa);
				System.out.println("");
			}
			else if (opcionelegida==8)
			{
				MenuPrincipal(empresa);
			}
			else
			{
				System.out.println("No valido");
			}
			
		} while (opcionelegida>7 || opcionelegida<1);
		
	}
}
