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
import java.util.GregorianCalendar;
import java.util.TreeMap;

import excepciones.LongitudInvalidaException;
import menus.Menus;
import mismetodos.MetodosGenerales;
import mismetodos.MetodosInterfazUsuario;


public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 8799656478674716609L;
	
	private String Nombre;
	private String CIF;
	//Oficinas
	private TreeMap <String, Oficina> listaOficinas= new TreeMap <String, Oficina> ();
	//Vehiculos
	private TreeMap <String, Vehiculo> listaVehiculo= new TreeMap <String, Vehiculo> ();
	private TreeMap <String, Vehiculo> listaVehiculosStock= new TreeMap <String, Vehiculo> ();
	private ArrayList<Vehiculo> listasVehiculosStockArrayList = new ArrayList<Vehiculo>();
	private TreeMap <String, Motocicletas> listaMotos= new TreeMap <String, Motocicletas> ();
	private TreeMap <String, Furgonetas> listaFurgonetas= new TreeMap <String, Furgonetas> ();
	private TreeMap <String, CochesElectricos> listaCochesElectricos= new TreeMap <String, CochesElectricos> ();
	private TreeMap <String, CochesCombustion> listaCochesCombustion= new TreeMap <String, CochesCombustion> ();
	//Clientes
	private TreeMap <String, Cliente> listaCliente= new TreeMap <String, Cliente> ();
	//Empleados
	private TreeMap <String, Empleado> listaEmpleado= new TreeMap <String, Empleado> ();
	//Alquileres
	private TreeMap <String, Alquiler> listaAlquileres = new TreeMap <String, Alquiler> ();
	private TreeMap <String, Alquiler> listaAlquileresActivos = new TreeMap <String, Alquiler> ();
	private TreeMap <String, Alquiler> listaDevoluciones = new TreeMap <String, Alquiler> ();
	//Categorias
	private TreeMap <String, Categoria> listaCategorias = new TreeMap <String, Categoria> ();
	//TiposVehiculos
	private ArrayList<String> listasTipodeCoche = new ArrayList<String>();
	//TiposDeCarnet
	private ArrayList<CarnetConducir> listasCarnet = new ArrayList<CarnetConducir>();
	
	
	
	//crear consrtructor con los datos minimos nombre y nif
	
	/**
	 * Cosntructor minimo para la empresa
	 * @param nif String nif unico para cada empresa
	 * @param Nombre String nombre de cada empresa
	 */
	public Empresa(String cif, String Nombre)
	{
		this.setNombre(Nombre);
		this.setCIF(cif);
		listaOficinas= new TreeMap <String, Oficina> ();
		listaVehiculo= new TreeMap <String, Vehiculo> ();
		listaVehiculosStock= new TreeMap <String, Vehiculo> ();
		listasVehiculosStockArrayList = new ArrayList<Vehiculo>();
		listaMotos= new TreeMap <String, Motocicletas> ();
		listaFurgonetas= new TreeMap <String, Furgonetas> ();
		listaCochesElectricos= new TreeMap <String, CochesElectricos> ();
		listaCochesCombustion= new TreeMap <String, CochesCombustion> ();
		listaCliente= new TreeMap <String, Cliente> ();
		listaEmpleado= new TreeMap <String, Empleado> ();
		listaAlquileres = new TreeMap <String, Alquiler> ();
		listaAlquileresActivos = new TreeMap <String, Alquiler> ();
		listaDevoluciones = new TreeMap <String, Alquiler> ();
		listaCategorias = new TreeMap <String, Categoria> ();
		listasTipodeCoche = new ArrayList<String>();
		listasCarnet = new ArrayList<CarnetConducir>();
	}
	


	public Empresa(String nombre, String cif, TreeMap<String, Oficina> listaOficinas,
			TreeMap<String, Vehiculo> listaVehiculo, TreeMap<String, Cliente> listaCliente,
			TreeMap<String, Empleado> listaEmpleado, TreeMap<String, Alquiler> listaAlquileres) 
	{
		this.setNombre(nombre);
		this.setCIF(cif);
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

	public String getCIF() 
	{
		return CIF;
	}

	public void setCIF(String cif) 
	{
		CIF = cif;
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
	
	public TreeMap<String, Vehiculo> getListaVehiculosstock() 
	{
		return listaVehiculosStock;
	}

	public void setListaVehiculosStock(TreeMap<String, Vehiculo> listaVehiculosStock) 
	{
		this.listaVehiculosStock = listaVehiculosStock;
	}
	
	public ArrayList<Vehiculo> getlistasVehiculosStockArrayList() 
	{
		return listasVehiculosStockArrayList;
	}
	
	public TreeMap<String, Motocicletas> getListaMotocicletas() 
	{
		return listaMotos;
	}

	public void setListaMotocicletas(TreeMap<String, Motocicletas> listaMotocicletas) 
	{
		this.listaMotos = listaMotocicletas;
	}
	
	public TreeMap<String, Furgonetas> getListaFurgonetas() 
	{
		return listaFurgonetas;
	}

	public void setListFurgosnetas(TreeMap<String, Furgonetas> listaFurgonetas) 
	{
		this.listaFurgonetas = listaFurgonetas;
	}
	
	public TreeMap<String, CochesCombustion> getListaCochesCombustion() 
	{
		return listaCochesCombustion;
	}

	public void setListaCochesElectricos(TreeMap<String, CochesElectricos> listaCochesElectrico) 
	{
		this.listaCochesElectricos = listaCochesElectrico;
	}
	
	public TreeMap<String, CochesElectricos> getListaCochesElectricos() 
	{
		return listaCochesElectricos;
	}

	public void setListaCochesCombustion(TreeMap<String, CochesCombustion> listaCochesCombustion) 
	{
		this.listaCochesCombustion = listaCochesCombustion;
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
	
	public ArrayList<String> getlistasTipodeCoche() 
	{
		return listasTipodeCoche;
	}

	public void setTipodeCoche(ArrayList<String> listastipodeCoche) 
	{
		listasTipodeCoche = listastipodeCoche;
	}
	public ArrayList<Vehiculo> getListasVehiculosStockArrayList() {
		return listasVehiculosStockArrayList;
	}

	public void setListasVehiculosStockArrayList(ArrayList<Vehiculo> listasVehiculosStockArrayList) {
		this.listasVehiculosStockArrayList = listasVehiculosStockArrayList;
	}

	public TreeMap<String, Motocicletas> getListaMotos() {
		return listaMotos;
	}

	public void setListaMotos(TreeMap<String, Motocicletas> listaMotos) {
		this.listaMotos = listaMotos;
	}

	public TreeMap<String, Alquiler> getListaAlquileresActivos() {
		return listaAlquileresActivos;
	}

	public void setListaAlquileresActivos(TreeMap<String, Alquiler> listaAlquileresActivos) {
		this.listaAlquileresActivos = listaAlquileresActivos;
	}

	public TreeMap<String, Alquiler> getListaDevoluciones() {
		return listaDevoluciones;
	}

	public void setListaDevoluciones(TreeMap<String, Alquiler> listaDevoluciones) {
		this.listaDevoluciones = listaDevoluciones;
	}

	public ArrayList<String> getListasTipodeCoche() {
		return listasTipodeCoche;
	}

	public void setListasTipodeCoche(ArrayList<String> listasTipodeCoche) {
		this.listasTipodeCoche = listasTipodeCoche;
	}

	public ArrayList<CarnetConducir> getListasCarnet() {
		return listasCarnet;
	}

	public void setListasCarnet(ArrayList<CarnetConducir> listasCarnet) {
		this.listasCarnet = listasCarnet;
	}

	public TreeMap<String, Vehiculo> getListaVehiculosStock() {
		return listaVehiculosStock;
	}

	public void setListaFurgonetas(TreeMap<String, Furgonetas> listaFurgonetas) {
		this.listaFurgonetas = listaFurgonetas;
	}


	//METODOS
	// MEtodos para leer y grabar una empresa con la serializacion
	
	/**
	 * Metodo que serializa una empresa
	 * @param empresa elemento de tipo Empresa, el cual es el que se graba
	 */
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
	
	/**
	 * Metodo que lee una empresa ya serializada, si esta serializada la lee, si no esta la crea.
	 * @return Devuelve el elemento Empresa 
	 * @throws IOException
	 */
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
	
	/**
	 * Metodo que busca un empleado en un ArrayList a partir de un Dni 
	 * @param dni Dni a partir el cual, busca al empleado al que le pertenez este dni
	 * @param e ArrayList donde estan todos los empleados en los que buscar
	 * @return devuelve un objeto de tipo empleado, si el dni introducido le pertenece, si  no devuelve un null
	 */
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
	
	/**
	 * Metodo que busca un cliente a partir de su DNI
	 * @param dni String que se utiliza para buscar al cliente
	 * @return Te devuelve el cliente que coincide su dni con el introducido
	 * 			Si ese cliente no existe, te devuelve un null
	 */
	public  Cliente BuscaCliente (String dni)
	{
		return listaCliente.get(dni);
	}
	
	/**
	 * Metodo que busca un vehiculo a partir de su matricula
	 * @param matricula String que se utiliza para buscar al vehiculo
	 * @return Te devuelve el vehiculo que coincide su matricula con la introducida
	 * 			Si ese vehiculo no existe, te devuelve un null
	 */
	public  Vehiculo BuscaVehiculo (String matricula)
	{
		return listaVehiculo.get(matricula);
	}
	
	/**
	 * Metodo que busca un vehiculo a partir de su matricula
	 * @param matricula String que se utiliza para buscar al vehiculo
	 * @return Te devuelve el vehiculo que coincide su matricula con la introducida
	 * 			Si ese vehiculo no existe, te devuelve un null
	 */
	public  Vehiculo BuscaVehiculoenStock (String matricula)
	{
		return listaVehiculosStock.get(matricula);
	}
	
	public static Vehiculo BuscaVehiculoenStockenArrayListporOficina(Oficina oficina,ArrayList <Vehiculo> v)
	{
		Vehiculo vehiculo = null;
		
		for (Vehiculo item : v) 
		{
			if(item.getOficina() == (oficina))
			{
				vehiculo = item;
				break;
			}
		}
		return vehiculo;
	}
	
	public static Vehiculo BuscaVehiculoenStockenArrayListporCategoria(Categoria categoria,ArrayList <Vehiculo> v)
	{
		Vehiculo vehiculo = null;
		
		for (Vehiculo item : v) 
		{
			if(item.getCategoria() == (categoria))
			{
				vehiculo = item;
				break;
			}
		}
		return vehiculo;
	}

	/**
	 * Metodo que busca una oficina a partir de su codigo
	 * @param codigo String que se utiliza para buscar la oficina
	 * @return Te devuelve la oficina que coincide su codigo con el introducido
	 * 			Si esa oficina no existe, te devuelve un null
	 */
	public  Oficina BuscaOficina(String codigo)
	{
		return listaOficinas.get(codigo);
	}
	
	/**
	 * Metodo que busca un alquiler a partir de su codigo
	 * @param codigo String que se utiliza para buscar al alquiler
	 * @return Te devuelve el alquiler que coincide su codigo con el introducido
	 * 			Si ese alquiler no existe, te devuelve un null
	 */
	public Alquiler BucaAlquileres(String codigo)
	{
		return listaAlquileres.get(codigo);
	}
	
	/**
	 * Metodo que busca una categoria a partir de su codigo
	 * @param codigo String que se utiliza para buscar la categoria
	 * @return Te devuelve la categoria que coincide su codigo con el introducido
	 * 			Si esa categoria no existe, te devuelve un null
	 */
	public Categoria BuscaCategoria(String codigo) 
	{
		return listaCategorias.get(codigo);
		
	}
	//METODOS AÑADE OBJETOS A TREEMAP
	
	/**
	 * Metodo que pide todos los datos para crear un cliente y lo añade al TreeMap ListaClientes 
	 * @throws LongitudInvalidaException
	 */
	public void AñadeClientes() throws LongitudInvalidaException
	{
		Cliente cliente=MetodosInterfazUsuario.PideDatosCliente();
		listaCliente.put(cliente.getDni(), cliente);
	}
	
	/**
	 * Metodo que añade un cliente pasado por parametros al TreeMap ListaClientes
	 * @param cliente Objeto de tipo Clientes
	 * @throws LongitudInvalidaException
	 */
	public void AñadeClientes(Cliente cliente) throws LongitudInvalidaException
	{
		listaCliente.put(cliente.getDni(), cliente);
	}
	
	/**
	 * Metodo que pide todos los datos para crear un empleado y lo añade al TreeMap ListaEmpleados
	 * @param empresa Objeto de tipo empresa, necesario para pedir ciertos datos
	 */
	public void AñadeEmpleado(Empresa empresa)
	{
		Empleado empleado = MetodosInterfazUsuario.PideDatosEmpleado(empresa);
		listaEmpleado.put(empleado.getDni(), empleado);
	}
	
	/**
	 * Metodo que pide todos los datos para crear una Oficina y lo añade al TreeMap ListaOficinas 
	 */
	public void AñadeOficinas()
	{
		Oficina oficina=MetodosInterfazUsuario.PideDatosOficina();
		listaOficinas.put(oficina.getCodigo(), oficina);
	}
	
	public void AñadeOficinas(String codigo)
	{
		Oficina oficina=MetodosInterfazUsuario.PideDatosOficina(codigo);
		listaOficinas.put(oficina.getCodigo(), oficina);
	}
	
	/**
	 * Metodo que añade al TreeMap ListaOficina una Oficina
	 * @param oficina Objeto del tipo oficina,el cual sera añadido.
	 */
	public void AñadeOficinas(Oficina oficina)
	{
		listaOficinas.put(oficina.getCodigo(), oficina);
	}
	
	/**
	 * Metodo que pide todos los datos para crear un vehiculo y aladirlo al TreeMap ListaVehiculos
	 * @param empresa Objeto de tipo empresa, necesario para pedir ciertos datos
	 */
	public void AñadeVehiculos(Empresa empresa)
	{
		Vehiculo vehiculo=MetodosInterfazUsuario.PideDatosVehiculo(empresa);
		
		listaVehiculo.put(vehiculo.getMatricula(), vehiculo);
		
		AñadeVehiculosStockArrayList(vehiculo);
	}
	
	/**
	 * Metodo que pide todos los datos para crear un vehiculo y aladirlo al TreeMap ListaVehiculos
	 * @param empresa Objeto de tipo empresa, necesario para pedir ciertos datos
	 */
	public void AñadeVehiculosaStock(Vehiculo vehiculo)
	{
		listaVehiculosStock.put(vehiculo.getMatricula(), vehiculo);
	}
	
	public void AñadeVehiculosStockArrayList(Vehiculo vehiculo)
	{
		listasVehiculosStockArrayList.add(vehiculo);	
	}
	
	public void AñadeCochesCombustion(Empresa empresa, CochesCombustion vehiculo)
	{
		listaCochesCombustion.put(vehiculo.getMatricula(), vehiculo);
	}
	
	public void AñadeCochesElectricos(Empresa empresa, CochesElectricos vehiculo)
	{
		listaCochesElectricos.put(vehiculo.getMatricula(), vehiculo);
	}
	
	public void AñadeMotos(Empresa empresa, Motocicletas vehiculo)
	{
		listaMotos.put(vehiculo.getMatricula(), vehiculo);
	}
	
	public void AñadeFurgonetas(Empresa empresa, Furgonetas vehiculo)
	{
		getListaFurgonetas().put(vehiculo.getMatricula(), vehiculo);
	}
	
	
	/**
	 * Metodo que pide todos los datos para crear un alquiler y lo añade al TreeMap Listaalquileres
	 * @param empresa Objeto de tipo empresa, necesario para pedir ciertos datos
	 * @throws LongitudInvalidaException
	 */
	public void AñadeAquileres(Empresa empresa) throws LongitudInvalidaException
	{
		Alquiler alquiler=MetodosInterfazUsuario.PideDatosAlquiler(empresa);
		listaAlquileres.put(alquiler.getCodigo(), alquiler);
		
		AñadeAquileresActivos(alquiler);
	}
	
	public void AñadeAquileresActivos(Alquiler alquiler) throws LongitudInvalidaException
	{
		listaAlquileresActivos.put(alquiler.getCodigo(), alquiler);
	}
	
	/**
	 * Metodo que pide todos los datos para crear una categoria y lo añade al TreeMap ListaCategorias
	 */
	public void AñadeCategoria()
	{
		Categoria categoria=MetodosInterfazUsuario.PideDatosCategoria();
		listaCategorias.put(categoria.getCodigo(), categoria);
	}
	
	/**
	 * Metodo que añade al TreeMap ListaOficina una Categoria
	 * @param categoria Objeto del tipo Categoria,el cual sera añadido.
	 */
	public void AñadeCategoria(Categoria categoria)
	{
		listaCategorias.put(categoria.getCodigo(), categoria);
	}
	
	
	public void AñadeTipoCoche()
	{
		String TipoCoche=MetodosGenerales.PideDatosString("Introduzca el tipo de vehiculo");
		listasTipodeCoche.add(TipoCoche);	
	}
	
	public void AñadeTipoCoche(String tipocoche)
	{
		listasTipodeCoche.add(tipocoche);
	}
	//METODOS ELIMINAR ELEMENTOS DE UN TREEMAP
	
	/**
	 * Metodo que elimina un cliente determinado de su TreeMap correspondiente
	 * @param cliente Objeto de tipo cliente, el cual sera eliminado.
	 */
	public void EliminaCliente(Cliente cliente)
	{
		listaCliente.remove(cliente.getDni());
	}
	
	/**
	 * Metodo que elimina un empleado determinado de su TreeMap correspondiente
	 * @param empleado Objeto de tipo Empleado, el cual sera eliminado.
	 */
	public void EliminaEmpleado(Empleado empleado)
	{
		listaEmpleado.remove(empleado.getDni());
	}
	
	/**
	 * Metodo que elimina una oficina determinada de su TreeMap correspondiente
	 * @param oficina Objeto de tipo Oficina, el cual sera eliminado.
	 */
	public void EliminaOficina(Oficina oficina)
	{
		listaOficinas.remove(oficina.getCodigo());
	}
	
	/**
	 * Metodo que elimina un alquiler determinado de su TreeMap correspondiente
	 * @param alquiler Objeto de tipo Alquiler, el cual sera eliminado.
	 */
	public void EliminaAlquilere(Alquiler alquiler)
	{
		listaAlquileres.remove(alquiler.getCodigo());
	}
	
	public void EliminaAlquilerActivo(Alquiler alquiler)
	{
		listaAlquileresActivos.remove(alquiler);
	}
	/**
	 * Metodo que elimina un vehiculo determinado de su TreeMap correspondiente
	 * @param veciculo Objeto de tipo Vehiculo, el cual sera eliminado.
	 */
	public void EliminaVehiculos(Vehiculo vehiculo)
	{
		listaVehiculo.remove(vehiculo.getMatricula());
	}
	
	/**
	 * Metodo que elimina un vehiculo determinado de su TreeMap correspondiente
	 * @param veciculo Objeto de tipo Vehiculo, el cual sera eliminado.
	 */
	public void EliminaVehiculosdeStock(Vehiculo vehiculo)
	{
		listaVehiculosStock.remove(vehiculo.getMatricula());
	}
	
	public void EliminaVehiculosdeStockArrayList(Vehiculo vehiculo, int i)
	{
		listasVehiculosStockArrayList.remove(i);
	}
	
	/**
	 * Metodo que elimina una categoria determinada de su TreeMap correspondiente
	 * @param categoria Objeto de tipo Categoria, el cual sera eliminado.
	 */
	public void EliminaCategoria(Categoria categoria) 
	{
		listaCategorias.remove(categoria.getCodigo());
	}
	
	//METODOS PARA MOFIFICAR
	
	/**
	 * Metodo que modifica una empresa
	 * @param empresa Obejeto necesario para mostrar ciertos datos
	 * @throws LongitudInvalidaException
	 */
	public void ModificarCategoria(Empresa empresa) throws LongitudInvalidaException
	{
		String codigo=MetodosGenerales.PideDatosString("Cual es el codigo de la categoria que desea modificar?");
		
		System.out.println("¿Que desea modificar?");
		System.out.println("1 - Codigo");
		System.out.println("2 - Descripcion");
		System.out.println("3 - Recargo");
		System.out.println("4 - Salir");
		int respuesta = MetodosGenerales.PideDatosNumericos();
			 if(respuesta==1)
			 {
				 	
				 	String codigonuevo=MetodosGenerales.PideDatosString("Cual es el nuevo codigo?");
					getListaCategorias().get(codigo).setCodigo(codigonuevo);
			 }
			 else if (respuesta==2)
			 {
				 	String descripcionueva=MetodosGenerales.PideDatosString("Cual es la nueva descripcion?");
					getListaCategorias().get(codigo).setDescripcion(descripcionueva);
			 }
			 else if (respuesta==3)
			 {
				 	int recargonuevo=MetodosGenerales.PideDatosNumericos("Cual es el nuevo recargo?");
					getListaCategorias().get(codigo).setRecargo(recargonuevo);
			 }

			 else if (respuesta==4)
			 {
				 Menus.MenuMantenimientoCategorias(empresa);
			 }

			 else 
			 {
				 
			 }
	}
	
	/**
	 * Metodo que modifica una vehiculo
	 * @param empresa Obejeto necesario para mostrar ciertos datos
	 * @throws LongitudInvalidaException
	 */
	public void ModificarVehiculos(Empresa empresa) throws LongitudInvalidaException 
	{
		MetodosInterfazUsuario.MostrarVehiculos(empresa);
		String matricula=MetodosGenerales.PideDatosString("Cual es la matricula del vehiculo que desea modificar?");
		int respuesta=0;
		do
		{
			System.out.println("¿Que desea modificar?");
			System.out.println("1 - Color");
			System.out.println("2 - KM");
			System.out.println("3 - Oficina");
			
			respuesta = MetodosGenerales.PideDatosNumericos();
			
				 if(respuesta==1)
				 {
					 	
					 	String colornuevo=MetodosGenerales.PideDatosString("Cual es el nuevo color?");
					 	getListaVehiculo().get(matricula).setMatricula(colornuevo);
				 }
				 else if (respuesta==2)
				 {
					 	String KMnuevos=MetodosGenerales.PideDatosString("Cuantos KM tiene ahora?");
					 	getListaVehiculo().get(matricula).setMarca(KMnuevos);
				 }
				 else if (respuesta==3)
				 {
					 	
					 	String recargonuevo=MetodosGenerales.PideDatosString("Cual es el nuevo modelo?");
						getListaVehiculo().get(matricula).setModelo(recargonuevo);
				 }
					
			if (empresa.getListaFurgonetas().get(matricula)!=null)	
			{
				System.out.println("furgoneta modificada");
			}
			else if (empresa.getListaMotocicletas().get(matricula)!=null)
			{
				System.out.println("Motocicleta modificada");
			}
			else if (empresa.getListaCochesCombustion().get(matricula)!=null)
			{
				System.out.println("Coche Combustion modificada");
			}
			else if (empresa.getListaCochesElectricos().get(matricula)!=null)
			{
				System.out.println("Coche Electrico modificada");
			}
				 
		}while (respuesta==4);
	}
	
	
	//TODO CORREGIR EL METODO COPIA Y PEGA DEL SUPERIOR
	public void ModificarOficina(Empresa empresa) throws LongitudInvalidaException
	{
		String codigo=MetodosGenerales.PideDatosString("Cual es el codigo de la oficina que desea modificar?");
		
		System.out.println("¿Que desea modificar?");
		System.out.println("1 - Codigo");
		System.out.println("2 - Descripcion");
		System.out.println("3 - Recargo");
		System.out.println("4 - Salir");
		int respuesta = MetodosGenerales.PideDatosNumericos();
			 if(respuesta==1)
			 {
				 	
				 	String codigonuevo=MetodosGenerales.PideDatosString("Cual es el nuevo codigo?");
					getListaCategorias().get(codigo).setCodigo(codigonuevo);
			 }
			 else if (respuesta==2)
			 {
				 	String descripcionueva=MetodosGenerales.PideDatosString("Cual es la nueva descripcion?");
					getListaCategorias().get(codigo).setDescripcion(descripcionueva);
			 }
			 else if (respuesta==3)
			 {
				 	int recargonuevo=MetodosGenerales.PideDatosNumericos("Cual es el nuevo recargo?");
					getListaCategorias().get(codigo).setRecargo(recargonuevo);
			 }

			 else if (respuesta==4)
			 {
				 Menus.MenuMantenimientoCategorias(empresa);
			 }

			 else 
			 {
				 
			 }
	}

	


}

