package acceso_BaseDatos;

import entidades.Empresa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Serializacion implements Serializable{
	
	public static void GrabaEmpresa (Empresa empresa) {
		FileOutputStream f=null;
		ObjectOutputStream o=null;
		
		try {
			f=new FileOutputStream("empresa.ser");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		o=ObjectOutputStream(f);
		
		try 
		{
			o.writeObject(empresa);
		}
		catch (IOException e)
		{
			
		}
		
	}

	private static ObjectOutputStream ObjectOutputStream(FileOutputStream f) {
		// TODO Auto-generated method stub
		return null;
	}
}
