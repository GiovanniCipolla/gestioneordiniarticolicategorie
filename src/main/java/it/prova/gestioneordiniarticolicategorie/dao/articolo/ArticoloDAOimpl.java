package it.prova.gestioneordiniarticolicategorie.dao.articolo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import javax.persistence.Query;

import it.prova.gestioneordiniarticolicategorie.model.Articolo;

public class ArticoloDAOimpl implements ArticoloDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);

	}

	@Override
	public void insert(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Long input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));

	}

	@Override
	public void removeArticoloUnlinkCategoria(Long id) throws Exception {
		entityManager.createNativeQuery("delete from articolo_categoria c where c.articolo_id = ?1").setParameter(1, id)
				.executeUpdate();
		entityManager.createNativeQuery("delete from articolo c where c.id = ?1").setParameter(1, id).executeUpdate();

	}

	@Override
	public int sumPriceArticoliDiCategroia(Long id) throws Exception {

		return entityManager
				.createQuery("select sum(a.prezzoSingolo) from Articolo a join a.categorie c where c.id = ?1")
				.setParameter(1, id).getFirstResult();
	}

	@Override
	public Long sumPriceArticoliByDestinatario(String nomeDestinatario) throws Exception {
		Long result = null;
		Query query = entityManager
				.createQuery(
						"select sum(a.prezzoSingolo) from Articolo a join a.ordine o where o.nomeDestinatario like ?1")
				.setParameter(1, nomeDestinatario);
//		result = query;
		return result;
	}

	@Override
	public List<Articolo> listArticoliWithErroriInOrdine() throws Exception {
		return entityManager
				.createQuery("select a from Articolo a join a.ordine o where a.dataInserimento > o.dataScadenza",
						Articolo.class)
				.getResultList();
	}

	@Override
	public List<Articolo> findAllByOrdine(Long idOrdine) throws Exception {
		TypedQuery<Articolo> query = entityManager.createQuery("from Articolo where ordine_id = ?1", Articolo.class);
		query.setParameter(1, idOrdine);
		return query.getResultList();
	}

}
