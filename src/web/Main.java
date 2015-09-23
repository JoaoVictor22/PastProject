package web;

import spark.Spark;
import spark.TemplateViewRoute;
import spark.template.mustache.MustacheTemplateEngine;
import controlador.CadastraControlador;
import controlador.HomeControlador;
import controlador.ListaControlador;
import controlador.SalvaControlador;


public class Main {

	public static void main(String[] args) {
		
		// precisa de um package static
		// onde ficam os css, javascript, imgs, conteúdo fixo
		Spark.staticFileLocation("/publico");
		
		// precisa de um package apresentação (views)
		// onde ficam os HTML'S
		MustacheTemplateEngine engine = new MustacheTemplateEngine("views");
		
		CadastraControlador cadastraControlador = new CadastraControlador();
		
		// get ou post
		// get quando vai ler informações, post submeter informações
		
		HomeControlador homeControlador = new HomeControlador();
		Spark.get("/", homeControlador, engine);
		
		//abrir o formulário
			
		ListaControlador listaControlador = new ListaControlador();
		
		
		SalvaControlador salvaControlador = new SalvaControlador();
		//submissão de formolurario
		Spark.post("/salva", salvaControlador, engine);
		Spark.get("/cadastro", cadastraControlador, engine);
		Spark.get("/home", homeControlador, engine);
		//mostrar cada filme
	
		
		Spark.get("/lista", listaControlador, engine);
		
	}

}
