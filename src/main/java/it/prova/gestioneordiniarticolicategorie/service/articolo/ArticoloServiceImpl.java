package it.prova.gestioneordiniarticolicategorie.service.articolo;


import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public class ArticoloServiceImpl implements ArticoloService {
	
	private ArticoloDAO articoloDAO;

	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) throws Exception {
		this.articoloDAO = articoloDAO;
	}

	@Override
	public List<Articolo> listaArticolo() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			articoloDAO.setEntityManager(entityManager);
			
			return articoloDAO.list();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Articolo leggiArticolo(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			articoloDAO.setEntityManager(entityManager);
			
			return articoloDAO.get(id);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiornaArticolo(Articolo input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			articoloDAO.setEntityManager(entityManager);
			
			articoloDAO.update(input);
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public void inserisciArticolo(Articolo input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			articoloDAO.setEntityManager(entityManager);
			
			articoloDAO.insert(input);
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public void elimminaArticolo(Long input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			articoloDAO.setEntityManager(entityManager);
			
			articoloDAO.delete(input);
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public void aggiungiCategoriaAArticolo(Articolo articoloInput, Categoria categoriaInput) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			articoloDAO.setEntityManager(entityManager);
			
			articoloInput = entityManager.merge(articoloInput);
			categoriaInput = entityManager.merge(categoriaInput);
			
			articoloInput.getCategorie().add(categoriaInput);
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimozioneArticoloDaScollegareACategoria(Long id)
			throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			articoloDAO.setEntityManager(entityManager);
			
			
			articoloDAO.removeArticoloUnlinkCategoria(id);
			
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public int sommaPrezzoArticoliDiCategoria(Long id) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			articoloDAO.setEntityManager(entityManager);
			
			
			return articoloDAO.sumPriceArticoliDiCategroia(id);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Long sommaPrezziArticoliDiUnDestinatario(String nomeDestinatario) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			articoloDAO.setEntityManager(entityManager);
			
			
			return articoloDAO.sumPriceArticoliByDestinatario(nomeDestinatario);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Articolo> listaArticoliConErroriInOrdine() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			articoloDAO.setEntityManager(entityManager);
			
			
			return articoloDAO.listArticoliWithErroriInOrdine();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}


	
	
	
}
