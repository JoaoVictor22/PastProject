package controlador;

import java.util.ArrayList;

import persistencia.UsuarioDAO;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class LoginControlador implements TemplateViewRoute {

	public ModelAndView handle(Request req, Response res) {
		// ver se tem o nick cadastrado - DICA findAll
		// se não tiver, redireciona para erro
		// se tiver, testa a senha
		// se senha errada, página de erro
		// se senha correta, loga session.attribute
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
					u = lista.get(i);
					req.session().attribute("usuario", u);
					return new ModelAndView(null, "intro.html");
				}			
			}
		}
		return new ModelAndView(null, "erroLogin.html");
	}
}
