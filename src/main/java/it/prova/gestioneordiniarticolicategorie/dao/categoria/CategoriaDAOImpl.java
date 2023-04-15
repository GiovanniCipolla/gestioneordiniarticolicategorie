package it.prova.gestioneordiniarticolicategorie.dao.categoria;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public class CategoriaDAOImpl implements CategoriaDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);

	}

	@Override
	public void insert(Categoria input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);

	}

	@Override
	public void delete(Categoria input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));

	}

	@Override
	public void removeCategoriaUnlinkArticolo(Long id) throws Exception {
		entityManager.createNativeQuery("delete from articolo_categoria c where c.categoria_id = ?1").setParameter(1, id)
				.executeUpdate();
		entityManager.createNativeQuery("delete from categroia c where c.id = ?1").setParameter(1, id).executeUpdate();

	}

	@Override
	public List<Categoria> allByThisOrdine(Long id) throws Exception {
		if (id == null)
			throw new Exception("Problema valore in input");
		return entityManager
				.createQuery("select distinct c from Categoria c join c.articoli a join a.ordine o where o.id = :id ",
						Categoria.class)
				.setParameter("id", id).getResultList();
	}
}
