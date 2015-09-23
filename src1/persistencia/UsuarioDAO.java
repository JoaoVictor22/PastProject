package persistencia;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Usuario;
import javax.xml.crypto.Data;
public class UsuarioDAO  {

	public void save(Usuario f) {
		try {
		
			File dir = new File("usuario");
			if (!dir.exists()) dir.mkdir();
			
			File arq = new File("usuario/" + f.getNick() + ".csv");
			if (arq.exists()) return;
		
			FileWriter writer = new FileWriter(arq);
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
			File arq = new File("usuario/" + f.getNick() + ".csv");
			
			if ( ! arq.exists()) return; 
			
			arq.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public Usuario load(String Nick) {		
		try {
			File arq = new File("usuario/" + Nick + ".csv");
			
			if ( ! arq.exists()) return null;
			
			Scanner scan = new Scanner(arq);
			String linha = scan.nextLine();
			String[] colunas = linha.split(";");
			
			Usuario f = new Usuario();
			f.setNick(Nick);
			f.setEmail(colunas[1]);
			f.setSenha(colunas[2]);
			
			scan.close();
			return f;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Usuario f) {
		
		File arq = new File("usuario/" + f.getNick() + ".csv");
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
				f.setNick((colunas[0]));
				f.setEmail(colunas[1]);
				f.setSenha(colunas[2]);
				
				lista.add(f);

				scan.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return lista;
	}
	


	public Usuario load(int chave) {
		// TODO Auto-generated method stub
		return null;
	}

}

	