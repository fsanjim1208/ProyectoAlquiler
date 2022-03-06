package entidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;


public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 8799656478674716669L;
	
	private String Nombre;
	private String NIF;
	private TreeMap <String, Oficina> listaOficinas= new TreeMap <String, Oficina> ();
	private TreeMap <String, Vehiculo> listaVehiculo= new TreeMap <String, Vehiculo> ();
	private TreeMap <String, Cliente> listaCliente= new TreeMap <String, Cliente> ();
	private TreeMap <String, Empleado> listaEmpleado= new TreeMap <String, Empleado> ();
	private TreeMap <String, Alquiler> listaAlquileres = new TreeMap <String, Alquiler> ();
 
	//crear consrtrucor con los datos minimos nombre y nif
	
	public Empresa(String nif, String Nombre)
	{
		this.setNombre(Nombre);
		this.setNIF(nif);
	}
	
	
	
	public Empresa(String nombre, String nif, TreeMap<String, Oficina> listaOficinas,
			TreeMap<String, Vehiculo> listaVehiculo, TreeMap<String, Cliente> listaCliente,
			TreeMap<String, Empleado> listaEmpleado, TreeMap<String, Alquiler> listaAlquileres) 
	{
		this.setNombre(nombre);
		this.setNIF(nif);
		this.setListaOficinas(listaOficinas);
		this.setListaVehiculo(listaVehiculo);
		this.setListaCliente(listaCliente);
		this.setListaEmpleado(listaEmpleado);
		this.setListaAlquileres(listaAlquileres);
	}

	//GETTERS AND SETTERS
	
	public String getNombre() 
	{
		return Nombre;
	}

	public void setNombre(String nombre) 
	{
		Nombre = nombre;
	}

	public String getNIF() 
	{
		return NIF;
	}

	public void setNIF(String nIF) 
	{
		NIF = nIF;
	}

	public TreeMap<String, Oficina> getListaOficinas() 
	{
		return listaOficinas;
	}

	public void setListaOficinas(TreeMap<String, Oficina> listaOficinas) 
	{
		this.listaOficinas = listaOficinas;
	}

	public TreeMap<String, Vehiculo> getListaVehiculo() 
	{
		return listaVehiculo;
	}

	public void setListaVehiculo(TreeMap<String, Vehiculo> listaVehiculo) 
	{
		this.listaVehiculo = listaVehiculo;
	}

	public TreeMap<String, Cliente> getListaCliente() 
	{
		return listaCliente;
	}

	public void setListaCliente(TreeMap<String, Cliente> listaCliente) 
	{
		this.listaCliente = listaCliente;
	}

	public TreeMap<String, Empleado> getListaEmpleado() 
	{
		return listaEmpleado;
	}

	public void setListaEmpleado(TreeMap<String, Empleado> listaEmpleado) 
	{
		this.listaEmpleado = listaEmpleado;
	}

	public TreeMap<String, Alquiler> getListaAlquileres() 
	{
		return listaAlquileres;
	}

	public void setListaAlquileres(TreeMap<String, Alquiler> listaAlquileres) 
	{
		this.listaAlquileres = listaAlquileres;
	}


	
	// MEtodos para leer y grabar una empresa con la serializacion
	

	public static void GrabaEmpresa (Empresa empresa) 
	{
		FileOutputStream file=null;
		ObjectOutputStream input=null;
		
		try 
		{
			file=new FileOutputStream("empresa.ser");
			input=new ObjectOutputStream(input);
			input.writeObject(empresa);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error al intentar grabar: "+ e.getLocalizedMessage());
		}
		catch (IOException e)
		{
			System.out.println("Error al intentar grabar: "+ e.getLocalizedMessage());
		}
	}	
	
	
	public static Empresa LeeEmpresa () throws IOException
	{
		Empresa empresa= null;
		
		
		File f =new File ("empresa.ser");
		
		
		//Si existe el fichero lee la empresa pero si no existe la crea con el constructor minimo
		if (f.exists())   
		{
			try 
			{
				FileInputStream file= new FileInputStream ("empresa.ser");
				ObjectInputStream input = new ObjectInputStream(file);
				empresa = (Empresa) input.readObject();
			} 
			catch (ClassNotFoundException e) 
			{
				System.out.println("Error al intentar leer: "+ e.getLocalizedMessage());
			} 
			catch (IOException e) 
			{
				System.out.println("Error al intentar leer: "+ e.getLocalizedMessage());
			}
		}
		else 
		{
			empresa = new Empresa("Nombre","NIF");
			GrabaEmpresa(empresa);
		}
		
		return empresa;
	}
	
	
	//Metodos
	
	public static Empleado BucaEmpleado(String dni,ArrayList <Empleado> e)
	{
		Empleado empleado = null;
		
		for (Empleado item : e) 
		{
			if(item.getDni().equals(dni))
			{
				empleado = item;
				break;
			}
		}
		return empleado;
	}
	
	/**
	 * Metodo que busca un empleado a partir de su DNI
	 * @param dni String que se utiliza para buscar al empleado
	 * @return Te devuelve el empleado que coincide su dni con el introducido
	 * 			Si ese empleado no existe, te devuelve un null
	 */
	public Empleado BucaEmpleado(String dni)
	{
		return listaEmpleado.get(dni);
	}
	
	public static Cliente BucaCliente(String dni,ArrayList <Cliente> c)
	{
		Cliente cliente = null;
		
		for (Cliente item : c) 
		{
			if(item.getDni().equals(dni))
			{
				cliente = item;
				break;
			}
		}
		return cliente;
	}
	
	public  Cliente BuscaCliente (String dni)
	{
		return listaCliente.get(dni);
	}
	
	public static Vehiculo BucaVehiculo(String matricula, ArrayList <Vehiculo> v)
	{
		Vehiculo vehiculo = null;
	
		for (Vehiculo item : v) 
		{
			if(item.getMatricula().equals(matricula))
			{
				vehiculo = item;
				break;
			}
		}
		return vehiculo;
	}
	
	public  Vehiculo BuscaVehiculo (String matricula)
	{
		return listaVehiculo.get(matricula);
	}
	
	public static Oficina BucaOficina(String codigo,ArrayList <Oficina> o)
	{
		Oficina oficina = null;
		
		for (Oficina item : o) 
		{
			if(item.getCodigo().equals(codigo))
			{
				oficina = item;
				break;
			}
		}
		return oficina;
	}
	
	public Oficina BucaOficina(String codigo)
	{
		return listaOficinas.get(codigo);
	}
	
	public static Alquiler BuscaAlquiler(String codigo,ArrayList <Alquiler> a)
	{
		Alquiler alquiler = null;
		
		for (Alquiler item : a) 
		{
			if(item.getCodigo().equals(codigo))
			{
				alquiler = item;
				break;
			}
		}
		return alquiler;
	}
	
	public Alquiler BucaAlquileres(String matricula)
	{
		return listaAlquileres.get(matricula);
	}
	
	public void AñadeVehiculos()
	{
		
	}
}

