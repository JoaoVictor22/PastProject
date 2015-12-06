package controlador;

import modelo.Pergunta;
import persistencia.PerguntaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ExcluiControlador implements TemplateViewRoute {
	private PerguntaDAO dao = new PerguntaDAO();
	@Override
	public ModelAndView handle(Request req, Response resp) {
		int codigo = Integer.parseInt(req.params("codigo")); // /excluir/:numero
		Pergunta pergunta = dao.load(codigo);
		System.out.println(pergunta);
		if (!pergunta.equals(null)) {
			dao.delete(pergunta);
		}		
		resp.redirect("/listapergunta");
		return null;
	}
	}


