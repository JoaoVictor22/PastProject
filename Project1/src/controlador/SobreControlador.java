package controlador;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class SobreControlador implements TemplateViewRoute {

	@Override
	public ModelAndView handle(Request arg0, Response arg1) {

		return new ModelAndView (null,"sobre.html");
	}

}
