package controlador;

import java.util.ArrayList;
import java.util.Collections;

import persistencia.PerguntaDAO;
import persistencia.UsuarioDAO;
import modelo.Pergunta;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class LoginControlador implements TemplateViewRoute {

	public ModelAndView handle(Request req, Response res) {
		
		req.queryMap("nick");
		req.queryMap("senha");
		Usuario u = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		lista = dao.findAll();
		

		String nick = req.queryParams("nick");
		String senha = req.queryParams("senha");

		for (int i = 0; i < lista.size(); i++) {
			if (nick.trim().equals(lista.get(i).getNick())) {
				if (senha.trim().equals(lista.get(i).getSenha())) {
					if(nick.trim().equals("administrador")){
						return new ModelAndView(null,"homeadimin.html"); 
					}
					u = lista.get(i);
					req.session().attribute("usuario", u);
					return new ModelAndView(null, "intro.html");
				}			
			}
		}
		return new ModelAndView(null, "erroLogin.html");
	}
}
