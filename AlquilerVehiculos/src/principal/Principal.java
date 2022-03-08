package principal;

import java.io.IOException;
import java.util.Collections;

import entidades.Empresa;
import excepciones.LongitudInvalidaException;
import mismetodos.MetodosGenerales;

public class Principal {

	public static void main(String[] args) throws IOException, LongitudInvalidaException {
		// TODO Auto-generated method stub
		
		Empresa empresa = Empresa.LeeEmpresa();
		
		menus.Menus.MenuPrincipal(empresa);
		
//		int dato=MetodosGenerales.PideDatosNumericos("kadjnf");
//		System.out.println(dato);
	}

}
