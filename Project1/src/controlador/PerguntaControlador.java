package controlador;

import java.util.HashMap;
import java.util.Map;

import modelo.Pergunta;
import persistencia.PerguntaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class PerguntaControlador implements TemplateViewRoute {
	
	private PerguntaDAO dao = new PerguntaDAO();
	
	@Override
	public ModelAndView handle(Request req, Response resp) {
		
		int codigo = Integer.parseInt(req.params("codigo"));
		System.out.println(codigo);
		Pergunta pergunta = dao.load(codigo);
		Map mapa = new HashMap();
		mapa.put("pergunta",pergunta);
		
		return new ModelAndView(mapa,"perguntas.html");
	}

}
