package menus;

import java.util.Scanner;

import metodos_personales.Generales;
import mismetodos.MetodosInterfazUsuario;

public class Menus {
	
	static Scanner lector =  new Scanner (System.in);
	
	public static void MenuPrincipal()
	{
		int opcionelegida = 0;
		
		Generales.SubrayaString("EMPRESA ALQUILER", "*");
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
				MenuMantenimiento();
			}
			else if (opcionelegida==2)
			{
				MenuAlquileres();
			}
			else if (opcionelegida==3)
			{
				MenuListados();
			}
			else
			{
				
			}
			
		} while (opcionelegida>4 || opcionelegida<1);
	}

	
	
	
	public static void MenuMantenimiento() 
	{
		int opcionelegida=0;
		
		
		Generales.SubrayaString("MANTENIMIENTO", "*");
		System.out.println("1_Oficinas");
		System.out.println("2_Vehiculos");
		System.out.println("3_Empleados");
		System.out.println("4_Clientes");
		System.out.println("5_Salir");
		
		opcionelegida= lector.nextInt();
//		lector.next();
		do 
		{
			if (opcionelegida==1)
			{
				MenuMantenimientoOficinas();
			}
			else if (opcionelegida==2)
			{
				MenuMantenimientoVehiculos();
			}
			else if (opcionelegida==3)
			{
				MenuMantenimientoEmpleados();	
			}
			else if (opcionelegida==4)
			{
				MenuMantenimientoClientes();
			}
			else if (opcionelegida==5)
			{
				MenuPrincipal();
			}
			else
			{
				System.out.println("Valido");
			}
			
		} while (opcionelegida>5 || opcionelegida<1);
		
	}
	public static void MenuMantenimientoOficinas()
	{
		int opcionelegida=0;
		
		Generales.SubrayaString("OFICINA", "*");
		System.out.println("1_Añade Oficinas");
		System.out.println("2_Modifica Oficinas");
		System.out.println("3_Elimina Oficinas");
		System.out.println("4_Salir");
		
		opcionelegida=lector.nextInt();
		if (opcionelegida==1)
		{
			
		}
		else if (opcionelegida==2)
		{
			
		}
		else if (opcionelegida==3)
		{
			
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento();
		}
	}
	
	public static void MenuMantenimientoVehiculos()
	{
		int opcionelegida=0;
		
		Generales.SubrayaString("VEHICULOS", "*");
		System.out.println("1_Añade Vehiculos");
		System.out.println("2_Modifica Vehiculos");
		System.out.println("3_Elimina Vehiculos");
		System.out.println("4_Salir");
		
		opcionelegida=lector.nextInt();
		if (opcionelegida==1)
		{
			
		}
		else if (opcionelegida==2)
		{
			
		}
		else if (opcionelegida==3)
		{
			
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento();
		}
	}
	
	public static void MenuMantenimientoEmpleados()
	{
		int opcionelegida=0;
		
		Generales.SubrayaString("EMPLEADOS", "*");
		System.out.println("1_Añade Empleados");
		System.out.println("2_Modifica Empleados");
		System.out.println("3_Elimina Empleados");
		System.out.println("4_Salir");
		
		opcionelegida=lector.nextInt();
		if (opcionelegida==1)
		{
			
		}
		else if (opcionelegida==2)
		{
			
		}
		else if (opcionelegida==3)
		{
			
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento();
		}
	}


	public static void MenuMantenimientoClientes()
	{
		int opcionelegida=0;
		
		Generales.SubrayaString("CLIENTES", "*");
		System.out.println("1_Añade Clientes");
		System.out.println("2_Modifica Clientes");
		System.out.println("3_Elimina Clientes");
		System.out.println("4_Salir");
		
		opcionelegida=lector.nextInt();
		if (opcionelegida==1)
		{
			
		}
		else if (opcionelegida==2)
		{
			
		}
		else if (opcionelegida==3)
		{
			
		}
		else if (opcionelegida==4) 
		{
			MenuMantenimiento();
		}
	}



	public static void MenuAlquileres() 
	{
		int opcionelegida=0;
		
		Generales.SubrayaString("ALQUILER", "*");
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
				MenuPrincipal();
			}
			else
			{
				System.out.println("Valido");
			}
			
		} while (opcionelegida>3 || opcionelegida<1);
		
	}
	
	
	
	public static void MenuListados() 
	{
		int opcionelegida=0;
		
		Generales.SubrayaString("LISTADOS Y CONSULTAS", "*");
		System.out.println("1_Listado de Alquileres por fecha");
		System.out.println("2_Listado de alquileres de un determinado vehiculo");
		System.out.println("3_Listado del stock de vehiculos de una oficina");
		System.out.println("4_Salir");
		
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
				
			}
			else if (opcionelegida==4)
			{
				MenuPrincipal();
			}
			else
			{
				System.out.println("No valido");
			}
			
		} while (opcionelegida>5 || opcionelegida<1);
		
	}
}
