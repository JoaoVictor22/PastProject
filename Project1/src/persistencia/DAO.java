package persistencia;

import java.util.ArrayList;

// geral ou abstrato
public interface DAO<T> {
	// método para salvar:
	// public void persist(T obj);	
	// public void insert(T obj);
	// public void store(T obj);
	public void save(T obj);	
	// método para excluir:
	// public void remove(T obj);
	public void delete(T obj);
	// método para carregar:
	// public T find(int chave);
	// public T open(int chave);
	// public T search(int chave);
	public T load(int chave);
	// método para atualizar/alterar registro existente:
	public void update(T obj);
	
	// encontra todos:
	public ArrayList<T> findAll();
	// public ArrayList<T> all();
	// public ArrayList<T> list();
	
	

}