package controlador;

import persistencia.PerguntaDAO;
import modelo.Pergunta;
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
		if(op.equals(pergunta2.getRespostacerta())){
			codigo++;
			Pergunta nova = dao.load(codigo);
			resp.redirect("/pergunta/"+codigo);
		}else{
			return new ModelAndView (null,"erro.html");
		}
		
		

		// Se acertou redirecionar para a próxima

		// Se acertou redirecionar para a prÃ³xima

		// codigo++;
		// Enviar um QUeryMap("pergunta", proxima_pergunta)
		// Se n acertar
		// res.redirect("PAGINA DE ERRO"|| "PERDEU")
		
		return new ModelAndView(null,"perguntas.html");
	}

}
