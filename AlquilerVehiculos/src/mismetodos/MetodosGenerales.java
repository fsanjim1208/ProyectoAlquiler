package mismetodos;

import java.io.Serializable;
import java.util.Scanner;

public class MetodosGenerales {
	
	
	static Scanner lector =  new Scanner (System.in);
	
	/**
	 * Metodo que pide datos de tipo enteros
	 * @param mensaje Mensaje de la pregunta de antes de pedir el dato
	 * @return
	 */
	public static int PideDatosNumericos(String mensaje) 
	{
		int datoPedido=0;
		
		boolean valido;
		do {
			
			try 
			{
				System.out.println(mensaje);
				datoPedido=lector.nextInt();
				lector.nextLine();
				
				valido=false;
			}
			catch  (Exception e)
			{
				System.out.println("un numero porfavor");
				valido=true;
			}
		}while (valido);
		return datoPedido;
	}
	
	/**
	 * Metodo que pide datos de tipo enteros
	 * @return 
	 */
	public static int PideDatosNumericos() 
	{
		int datoPedido=0;
		
		boolean valido;
		do {
			
			try 
			{
				datoPedido=lector.nextInt();
				lector.nextLine();
				valido=false;
			}
			catch  (Exception e)
			{
				System.out.println("un numero porfavor");
				valido=true;
			}
		}while (valido);
		return datoPedido;
	}
	
	/**
	 * Metodo que pide datos de tipo String
	 * @param mensaje Mensaje de la pregunta de antes de pedir el dato
	 * @return
	 */
	public static String PideDatosString(String mensaje)
	{
		String datoPedido;
		
		System.out.println(mensaje);
		datoPedido=lector.nextLine();
		return datoPedido;
	}
	
	/**
	 * Metodo que busca una cadena dentro de otra
	 * @param cadena_donde_buscar String donde vamos a buscar la otra cadena
	 * @param cadena_a_buscar String Cadena que vamos a buscar 
	 * @return devuelve la posicion en la que s encuentra la cadena, si la cadena no se encuentra se devuelve un -1
	 */
	public static int busca_cadena(String cadena_donde_buscar, String cadena_a_buscar) {
		int contador;
		int long_a_buscar;
		int long_donde_buscar;
		int posicion;
		String trozo;
		long_a_buscar = cadena_a_buscar.length();
		long_donde_buscar = cadena_donde_buscar.length();
		contador = 0;
		posicion = -1;
		do {
			trozo = cadena_donde_buscar.substring(contador-1,contador+long_a_buscar-1);
			if (trozo.equals(cadena_a_buscar)) {
				posicion = contador;
			}
			contador = contador+1;
		} while (!(contador==long_donde_buscar-long_a_buscar+1 || posicion>=0));
		return posicion;
	}
	
	/**
	 * Metodo que subraya una cadena de texto con un caracter dado
	 * @param mensaje Cadena la cual queremos subrayar
	 * @param Caractersubrayar Caracter con el cual vamos a subrayar
	 */
	public static void SubrayaString(String mensaje, String Caractersubrayar)
	{
		String subrayado = "";
		System.out.println(mensaje);
		for(int i=0;i<mensaje.length();i++) 
		{
			subrayado = subrayado.concat(Caractersubrayar);
		}
		System.out.println(subrayado);
	}
	
	
}
