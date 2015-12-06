package controlador;

import java.util.ArrayList;

import persistencia.UsuarioDAO;
import modelo.Usuario;
import spark.*;

public class CadastraControlador implements TemplateViewRoute {

		public ModelAndView handle(Request req, Response resp) {

			return new ModelAndView (null,"cadastro.html");

		}
}
