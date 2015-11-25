package controlador;

import persistencia.PerguntaDAO;
import persistencia.UsuarioDAO;
import modelo.Pergunta;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class TestaControlador implements TemplateViewRoute {
	
	private PerguntaDAO dao = new PerguntaDAO();
	
	@Override
	public ModelAndView handle(Request req, Response resp) {
		
		int codigo = Integer.parseInt(req.params("codigo"));
		Pergunta pergunta2 = dao.load(codigo);
		//carregar o arquivo correspondente ao código.
		// Comparar a resposta certa com a resposta fornecida pelo usuario
		String op = req.queryMap("op").value();
		int acertos = req.session().attribute("acertos");
		if(op.equals(pergunta2.getRespostacerta())){
			acertos++;
			req.session().attribute("acertos",acertos);
			codigo++;
			Pergunta nova = dao.load(codigo);
			Usuario u = req.session().attribute("usuario");
			UsuarioDAO dao = new UsuarioDAO();
			
			u.setPerguntausuario(acertos);
			dao.update(u);
			
			resp.redirect("/pergunta/"+codigo);
		}else{
			resp.redirect("erro.html");
			return null;
		}

		
		return new ModelAndView(null,"perguntas.html");
	}

}
