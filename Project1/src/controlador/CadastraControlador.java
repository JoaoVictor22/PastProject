package controlador;

import java.util.ArrayList;

import persistencia.UsuarioDAO;
import modelo.Usuario;
import spark.*;

public class CadastraControlador implements TemplateViewRoute {

		public ModelAndView handle(Request req, Response resp) {
		
<<<<<<< HEAD
=======
			
>>>>>>> 250b1c4277b73bbf9ee7d54546c21385fdfa6e67
			return new ModelAndView (null,"cadastro.html");

		}
}
