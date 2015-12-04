package persistencia;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



import modelo.Pergunta;
import modelo.Usuario;

public class PerguntaDAO {


	public void save(Pergunta p){
			
		try {
			// diretório
			File dir = new File("perguntas");
			if (!dir.exists()) dir.mkdir();
			p.setCodigo(geraCodigo());
			// arquivo individual
			File arq = new File("perguntas/" + p.getCodigo() + ".csv");
			if (arq.exists()) return;
			// gravar os dados
			FileWriter writer = new FileWriter(arq);
			writer.write(p.getPergunta() + ";");
			writer.write(p.getResposta1() + ";");
			writer.write(p.getResposta2() + ";");
			writer.write(p.getResposta3() + ";");
			writer.write(p.getResposta4() + ";");
			writer.write(p.getResposta5() + ";");
			writer.write(p.getRespostacerta() + ";");
			writer.write(p.getCodigo());
			// fechar o arquivo
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Pergunta load(int codigo) {		
		try {
			File arq = new File("perguntas/" + codigo + ".csv");
			
			if ( ! arq.exists()) return null;
			
			Scanner scan = new Scanner(arq);
			String linha = scan.nextLine();
			String[] colunas = linha.split(";");
			
			Pergunta p = new Pergunta();
			p.setPergunta(colunas[0]);
			p.setResposta1(colunas[1]);
			p.setResposta2(colunas[2]);
			p.setResposta3(colunas[3]);
			p.setResposta4(colunas[4]);
			p.setResposta5(colunas[5]);
			p.setRespostacerta(colunas[6]);
			System.out.println(colunas[7]);
			p.setCodigo(codigo);
			
			return p;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public int geraCodigo() {
		File arq = new File("perguntas/codigo.csv");
		if (arq.exists()) {
			try {
				Scanner scan = new Scanner(arq);
				String s = scan.nextLine();
				System.out.println(s);
				int n = Integer.parseInt(s);
				scan.close();
				n++;
				FileWriter writer = new FileWriter(arq);
				writer.write(Integer.toString(n));
				writer.flush();
				writer.close();
				return n;
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		else {
			try {
				FileWriter writer = new FileWriter(arq);
				writer.write("0");
				writer.flush();
				writer.close();
				return 0;
			} catch (IOException e) {
		
				
				e.printStackTrace();
			}
			
		}
		return -1;
	}

	
	public ArrayList<Pergunta> findAll() {
		ArrayList<Pergunta> pergunta = new ArrayList<Pergunta>();
		try {
			File dir = new File("perguntas");		
			File[] arqs = dir.listFiles();
			for (File arq : arqs) { // for each
				Scanner scan = new Scanner(arq);
				String linha = scan.nextLine();
				String[] colunas = linha.split(";");
				
				Pergunta p = new Pergunta();
				p.setPergunta((colunas[0]));
				p.setResposta1(colunas[1]);
				p.setResposta2(colunas[2]);
				p.setResposta3((colunas[3]));
				p.setResposta4((colunas[4]));
				p.setResposta5((colunas[5]));
				p.setRespostacerta((colunas[6]));
				p.setCodigo(Integer.parseInt(colunas[7]));
				pergunta.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pergunta;
	}
	
	
	}
	
	
	
