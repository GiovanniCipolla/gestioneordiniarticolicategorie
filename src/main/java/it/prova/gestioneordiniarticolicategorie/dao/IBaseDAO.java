package it.prova.gestioneordiniarticolicategorie.dao;

import java.util.List;
import javax.persistence.EntityManager;

public interface IBaseDAO<T>{
	
	// questo mi serve per l'injection
	public void setEntityManager(EntityManager entityManager);
	
	public List<T> list() throws Exception;

	public T get(Long id) throws Exception;

	public void update(T o) throws Exception;

	public void insert(T o) throws Exception;

	public void delete(Long o) throws Exception;

}
