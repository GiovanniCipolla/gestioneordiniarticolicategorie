package it.prova.gestioneordiniarticolicategorie.dao.ordine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);

	}

	@Override
	public void delete(Long input) throws Exception {
		if (input == null)
			throw new Exception("Problema valore in input");
		entityManager.remove(entityManager.merge(input));

	}

	@Override
	public List<Ordine> allByThisCategoria(Long id) throws Exception {
		if (id == null)
			throw new Exception("Problema valore in input");

		return entityManager
				.createQuery("select o from Ordine o join o.articoli a join a.categorie c where c.id = :id ",
						Ordine.class)
				.setParameter("id", id).getResultList();
	}

	@Override
	public Ordine getOrdinePiuRecenteByCategoria(Long id) throws Exception {

		return entityManager.createQuery(
				"select o from Ordine o join o.articoli a join a.categorie c where c.id = :id order by o.dataSpedizione desc",
				Ordine.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<String> andressDegliOrdiniContenentiNumeroSeriale(String stringaNumeroSeriale) throws Exception {
		return entityManager.createQuery(
				"select distinct o.indirizzoSpedizione from Ordine o join o.articoli a where a.numeroSeriale like ?1",
				String.class).setParameter(1, "%" + stringaNumeroSeriale + "%").getResultList();
	}

}
