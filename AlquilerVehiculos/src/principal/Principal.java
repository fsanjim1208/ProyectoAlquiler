package principal;

import java.io.IOException;
import java.util.Collections;

import entidades.Empresa;
import excepciones.LongitudInvalidaException;
import mismetodos.MetodosGenerales;
import mismetodos.MetodosInterfazUsuario;

public class Principal {

	public static void main(String[] args) throws IOException, LongitudInvalidaException {
		// TODO Auto-generated method stub
		
		Empresa empresa = Empresa.LeeEmpresa();
		
		menus.Menus.MenuPrincipal(empresa);
	
	}

}
