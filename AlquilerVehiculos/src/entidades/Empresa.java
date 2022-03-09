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

import excepciones.LongitudInvalidaException;
import mismetodos.MetodosInterfazUsuario;


public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 8799656478674716609L;
	
	private String Nombre;
	private String NIF;
	private  TreeMap <String, Oficina> listaOficinas= new TreeMap <String, Oficina> ();
	private  TreeMap <String, Vehiculo> listaVehiculo= new TreeMap <String, Vehiculo> ();
	private  TreeMap <String, Cliente> listaCliente= new TreeMap <String, Cliente> ();
	private  TreeMap <String, Empleado> listaEmpleado= new TreeMap <String, Empleado> ();
	private  TreeMap <String, Alquiler> listaAlquileres = new TreeMap <String, Alquiler> ();
	private  TreeMap <String, Categoria> listaCategorias = new TreeMap <String, Categoria> ();
 
	//crear consrtrucor con los datos minimos nombre y nif
	
	public Empresa(String nif, String Nombre)
	{
		this.setNombre(Nombre);
		this.setNIF(nif);
		listaOficinas= new TreeMap <String, Oficina> ();
		listaVehiculo= new TreeMap <String, Vehiculo> ();
		listaCliente= new TreeMap <String, Cliente> ();
		listaEmpleado= new TreeMap <String, Empleado> ();
		listaAlquileres = new TreeMap <String, Alquiler> ();
		listaCategorias = new TreeMap <String, Categoria> ();
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
	
	public TreeMap<String, Categoria> getListaCategorias() 
	{
		return listaCategorias;
	}

	public void setListaCategorias(TreeMap<String, Categoria> listaCategorias) 
	{
		this.listaCategorias = listaCategorias;
	}


	//METODOS
	// MEtodos para leer y grabar una empresa con la serializacion
	

	public static void GrabaEmpresa (Empresa empresa) 
	{
		FileOutputStream file=null;
		ObjectOutputStream input=null;
		
		try 
		{
			file=new FileOutputStream("empresa.ser");
			input=new ObjectOutputStream(file);
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
			empresa = MetodosInterfazUsuario.PideDatosEmpresa();
			GrabaEmpresa(empresa);
		}
		
		return empresa;
	}
	
	//METODOS BUSCA OBJETOS DE TREEMAP Y DE ARRAYLIST
	
	public static Empleado BuscaEmpleado(String dni,ArrayList <Empleado> e)
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
	public Empleado BuscaEmpleado(String dni)
	{
		return listaEmpleado.get(dni);
	}
	
	public static Cliente BuscaCliente(String dni,ArrayList <Cliente> c)
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
	
	public static Vehiculo BuscaVehiculo(String matricula, ArrayList <Vehiculo> v)
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
	
	public static Oficina BuscaOficina(String codigo,ArrayList <Oficina> o)
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
	
	public  Oficina BuscaOficina(String codigo)
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
	
	public Alquiler BucaAlquileres(String codigo)
	{
		return listaAlquileres.get(codigo);
	}
	
	public Categoria BuscaCategoria(String codigo) 
	{
		return listaCategorias.get(codigo);
		
	}
	//METODOS AÑADE OBJETOS A TREEMAP
	
	public void AñadeClientes() throws LongitudInvalidaException
	{
		Cliente cliente=MetodosInterfazUsuario.PideDatosCliente();
		listaCliente.put(cliente.getDni(), cliente);
	}
	
	public void AñadeEmpleado()
	{
		Empleado empleado = MetodosInterfazUsuario.PideDatosEmpleado();
		listaEmpleado.put(empleado.getDni(), empleado);
	}
	
	public void AñadeOficinas()
	{
		Oficina oficina=MetodosInterfazUsuario.PideDatosOficina();
		listaOficinas.put(oficina.getCodigo(), oficina);
	}
	
	public void AñadeVehiculos()
	{
		Vehiculo vehiculo=MetodosInterfazUsuario.PideDatosVehiculo();
		listaVehiculo.put(vehiculo.getMatricula(), vehiculo);
	}
	
	public void AñadeAquileres() throws LongitudInvalidaException
	{
		Alquiler alquiler=MetodosInterfazUsuario.PideDatosAlquiler();
		listaAlquileres.put(alquiler.getCodigo(), alquiler);
	}
	
	public void AñadeCategoria()
	{
		Categoria categoria=MetodosInterfazUsuario.PideDatosCategoria();
		listaCategorias.put(categoria.getCodigo(), categoria);
	}
	
	//METODOS ELIMINAR ELEMENTOS DE UN TREEMAP
	
	public void EliminaCliente(Cliente cliente)
	{
		listaCliente.remove(cliente.getDni());
	}
	
	public void EliminaEmpleado(Empleado empleado)
	{
		listaEmpleado.remove(empleado.getDni());
	}
	
	public void EliminaOficina(Oficina oficina)
	{
		listaOficinas.remove(oficina.getCodigo());
	}
	
	public void EliminaAlquilere(Alquiler alquiler)
	{
		listaAlquileres.remove(alquiler.getCodigo());
	}
	
	public void EliminaVehiculos(Vehiculo vehiculo)
	{
		listaVehiculo.remove(vehiculo.getMatricula());
	}
	
	public void EliminaCategoria(Categoria categoria) 
	{
		listaCategorias.remove(categoria.getCodigo());
	}
	

}

