package persistencia;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Usuario;

import javax.xml.crypto.Data;
public class UsuarioDAO  {

	public void save(Usuario f) {
		try {
			f.setCodigo(geraCodigo());
			File dir = new File("usuario");
			if (!dir.exists()) dir.mkdir();
			
			File arq = new File("usuario/" + f.getCodigo() + ".csv");
			if (arq.exists()) return;
		
			FileWriter writer = new FileWriter(arq);
			writer.write(f.getCodigo() + ";");
			writer.write(f.getNick() + ";");
			writer.write(f.getEmail() + ";");
			writer.write(f.getSenha() + "\n");
		
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Usuario f) {
		try {
			File arq = new File("usuario/" + f.getCodigo() + ".csv");
			
			if ( ! arq.exists()) return; 
			
			arq.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public Usuario load(int codigo) {		
		try {
			File arq = new File("usuario/" + codigo + ".csv");
			
			if ( ! arq.exists()) return null;
			
			Scanner scan = new Scanner(arq);
			String linha = scan.nextLine();
			String[] colunas = linha.split(";");
			
			Usuario f = new Usuario();
			f.setCodigo(codigo);
			f.setNick(colunas[1]);
			f.setEmail(colunas[2]);
			f.setSenha(colunas[3]);
			
			scan.close();
			return f;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Usuario f) {
		
		File arq = new File("usuario/" + f.getCodigo() + ".csv");
		arq.delete();
		save(f);
		
	}

	public ArrayList<Usuario> findAll() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			File dir = new File("usuario");		
			File[] arqs = dir.listFiles();
			for (File arq : arqs) { 
				Scanner scan = new Scanner(arq);				
				String linha = scan.nextLine();
				String[] colunas = linha.split(";");				
			
				Usuario f = new Usuario();
				f.setCodigo(Integer.parseInt(colunas[0]));
				f.setNick(colunas[1].trim());
				f.setEmail(colunas[2].trim());
				f.setSenha(colunas[3].trim());				
				lista.add(f);
				scan.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public int geraCodigo() {
		File arq = new File("usuario/codigo.csv");
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
}


	