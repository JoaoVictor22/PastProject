package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import modelo.Pergunta;
import persistencia.PerguntaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ListaPerguntaControlador implements TemplateViewRoute {

	private PerguntaDAO dao = new PerguntaDAO();

	@Override
	public ModelAndView handle(Request arg0, Response arg1) {
		ArrayList<Pergunta> pergunta = dao.findAll();
		HashMap<String, ArrayList<Pergunta>> mapa = new HashMap<String, ArrayList<Pergunta>>();
		// variavel html //variavel java
		mapa.put("perguntas", pergunta);

		return new ModelAndView(mapa, "listar_perguntas.html");
	}

}
