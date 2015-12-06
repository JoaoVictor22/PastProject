package web;

import spark.*;
import spark.template.mustache.MustacheTemplateEngine;
import controlador.*;

public class Main {

	public static void main(String[] args) {
		
		// precisa de um package static
		// onde ficam os css, javascript, imgs, conte�do fixo
		Spark.staticFileLocation("/pub");
		
		// precisa de um package apresenta��o (views)
		// onde ficam os HTML'S
		MustacheTemplateEngine engine = new MustacheTemplateEngine("views");
		
		CadastraControlador cadastraControlador = new CadastraControlador();
		
		// get ou post
		// get quando vai ler informa��es, post submeter informa��es
		
		HomeControlador homeControlador = new HomeControlador();
		Spark.get("/", homeControlador, engine);
		
		//abrir o formul�rio
			
		ListaControlador listaControlador = new ListaControlador();
		
		
		SalvaControlador salvaControlador = new SalvaControlador();
		//submiss�o de formolurario
		Spark.post("/salva", salvaControlador, engine);
		Spark.get("/cadastro", cadastraControlador, engine);
		Spark.get("/home", homeControlador, engine);
		//mostrar cada filme
	
		
		Spark.get("/lista", listaControlador, engine);
		
		EditaControlador EditaControlador = new EditaControlador();
		Spark.get("/editar", EditaControlador, engine);

		SalvarEditarControlador SalvaEditarControlador = new SalvarEditarControlador();
		Spark.post("/edita", SalvaEditarControlador, engine);
		
		TestaControlador testaControlador = new TestaControlador();
		Spark.post("/testa/:codigo", testaControlador, engine);
		
		PerguntaControlador perguntaControlador = new PerguntaControlador();
		Spark.get("/pergunta/:codigo",perguntaControlador,engine);

		
		CadastraPerguntasControlador cadastraPerguntaControlador = new CadastraPerguntasControlador();
		Spark.get("/cadastroperguntas",cadastraPerguntaControlador,engine);
		
		SalvaPerguntaControlador salvaPerguntaControlador = new SalvaPerguntaControlador();
		Spark.post("/salvarPergunta",salvaPerguntaControlador,engine);

		LoginControlador loginControlador = new LoginControlador();
		Spark.post("/loga", loginControlador, engine);

		SobreControlador sobreControlador = new SobreControlador();
		Spark.get("/sobre", sobreControlador, engine);
		
	}
}
