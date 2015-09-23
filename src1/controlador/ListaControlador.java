package controlador;


import java.util.ArrayList;
import java.util.HashMap;





import modelo.Usuario;
import persistencia.UsuarioDAO;
import spark.*;

public class ListaControlador implements TemplateViewRoute {
	
	private UsuarioDAO dao = new UsuarioDAO();
	
	
	
	@Override
	public ModelAndView handle(Request arg0, Response arg1) {
		ArrayList<Usuario> usuarios = dao.findAll();
		HashMap<String, ArrayList<Usuario>> mapa = new HashMap<String, ArrayList<Usuario>>();
				//variavel html //variavel java
		mapa.put("usuarios", usuarios);
		
		return new ModelAndView(mapa, "listar.html");
	}
	
}
