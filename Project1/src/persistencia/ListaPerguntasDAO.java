package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Pergunta;

public class ListaPerguntasDAO {
	
	public void save(ArrayList<Pergunta> lp, int codigousuario){
		
		try {
			// diretório
			File dir = new File("listaperguntas");
			if (!dir.exists()) dir.mkdir();
			// arquivo individual
			File arq = new File("listaperguntas/" + codigousuario + ".csv");
			if (arq.exists()) return;
			// gravar os dados
			FileWriter writer = new FileWriter(arq);
			for(int i=0;i<10;i++){
			writer.write(lp.get(i).getCodigo()+";");
			}
			// fechar o arquivo
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Integer> load(int codigousuario) {		
		try {
			File arq = new File("listaperguntas/" + codigousuario + ".csv");
			
			if ( ! arq.exists()) return null;
			
			Scanner scan = new Scanner(arq);
			String linha = scan.nextLine();
			String[] colunas = linha.split(";");
			
			ArrayList<Integer> n = new ArrayList<Integer>();
			for(int j = 0;j<10;j++){
			n.add(Integer.parseInt(colunas[j]));
			
			}
			return n;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;

	}
}
