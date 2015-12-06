package controlador;

import java.util.ArrayList;

import persistencia.UsuarioDAO;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class SalvaControlador implements TemplateViewRoute {

	private UsuarioDAO dao = new UsuarioDAO();

	@Override
	public ModelAndView handle(Request req, Response resp) {
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario.setNick(req.queryMap("nick").value());
		usuario.setSenha(req.queryMap("senha").value());

		String nick = req.queryParams("nick");
		String senha = req.queryParams("senha");
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		lista = dao.findAll();
		System.out.println(lista);
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == null) {
				dao.save(usuario);
				return new ModelAndView(null,"home.html");
			}
			if (nick.trim().equals(lista.get(i).getNick())) {
				return new ModelAndView(null,"erro_cadastro.html");
			}
		}
		dao.save(usuario);
		return new ModelAndView(null,"home.html");	
		
	}
}