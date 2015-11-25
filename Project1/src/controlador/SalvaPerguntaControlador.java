package controlador;

import modelo.Pergunta;
import persistencia.PerguntaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class SalvaPerguntaControlador implements TemplateViewRoute{

	private PerguntaDAO dao = new PerguntaDAO();
	
	@Override
	public ModelAndView handle(Request req, Response res) {
		
		Pergunta pergunta = new Pergunta();
		pergunta.setPergunta(req.queryMap("pergunta").value());
		pergunta.setResposta1(req.queryMap("op1").value());
		pergunta.setResposta2(req.queryMap("op2").value());
		pergunta.setResposta3(req.queryMap("op3").value());
		pergunta.setResposta4(req.queryMap("op4").value());
		pergunta.setResposta5(req.queryMap("op5").value());
		pergunta.setRespostacerta(req.queryMap("certa").value());
		
		dao.save(pergunta);
		res.redirect("/cadastroperguntas");
		
		return null;
	}

}
