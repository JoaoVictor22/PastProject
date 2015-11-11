package controlador;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class SalvarEditarControlador implements TemplateViewRoute{

private UsuarioDAO dao = new UsuarioDAO();
	
	
	@Override
	public ModelAndView handle(Request req, Response resp) {
		Usuario usuario = new Usuario();
		usuario.setNick(req.queryMap("nick").value());
		usuario.setSenha(req.queryMap("senha").value());
		usuario.setEmail(req.queryMap("email").value());
		
		
		
		dao.update(usuario);
		resp.redirect("/");
		return null;
	}
}