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
		
		Usuario u = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		lista = dao.findAll();

		String nick = req.queryParams("nick");
		String senha = req.queryParams("senha");

		for (int i = 0; i < lista.size(); i++) {
			if (nick.trim().equals(lista.get(i).getNick())) {
				if (senha.trim().equals(lista.get(i).getSenha())) {
					return new ModelAndView(null, "erro.html");
				}
				else{
		Usuario usuario = new Usuario();
		usuario.setNick(req.queryMap("nick").value());
		usuario.setSenha(req.queryMap("senha").value());
		usuario.setEmail(req.queryMap("email").value());
		usuario.setPerguntausuario(0);

		dao.save(usuario);
		resp.redirect("/home");
		return null;
				}
			}
		}
		return null;
	}
}