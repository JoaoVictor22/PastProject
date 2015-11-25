package controlador;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class CadastraPerguntasControlador implements TemplateViewRoute {

	@Override
	public ModelAndView handle(Request resp, Response req) {
		
		return new ModelAndView(null,"cadastro_pergunta.html");
	}

}
