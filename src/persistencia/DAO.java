package persistencia;

import java.util.ArrayList;

// geral ou abstrato
public interface DAO<T> {
	// m�todo para salvar:
	// public void persist(T obj);	
	// public void insert(T obj);
	// public void store(T obj);
	public void save(T obj);	
	// m�todo para excluir:
	// public void remove(T obj);
	public void delete(T obj);
	// m�todo para carregar:
	// public T find(int chave);
	// public T open(int chave);
	// public T search(int chave);
	public T load(int chave);
	// m�todo para atualizar/alterar registro existente:
	public void update(T obj);
	
	// encontra todos:
	public ArrayList<T> findAll();
	// public ArrayList<T> all();
	// public ArrayList<T> list();
	
	

}