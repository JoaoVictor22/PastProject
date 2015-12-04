package controlador;

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
		Usuario usuario = new Usuario();
		usuario.setNick(req.queryMap("nick").value());
		usuario.setSenha(req.queryMap("senha").value());
		usuario.setEmail(req.queryMap("email").value());
		
		
		
		dao.save(usuario);
		resp.redirect("/home");
		return null;
	}

}
