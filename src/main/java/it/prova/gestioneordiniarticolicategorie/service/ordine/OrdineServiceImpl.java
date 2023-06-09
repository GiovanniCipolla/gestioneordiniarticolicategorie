package it.prova.gestioneordiniarticolicategorie.service.ordine;

import java.util.List;

import javax.persistence.EntityManager;

import exception.CustomException;
import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public class OrdineServiceImpl implements OrdineService{

	private OrdineDAO ordineDAO;
	private ArticoloDAO articoloDAO;

	@Override
	public void setOrdineDAO(OrdineDAO ordineDAO) throws Exception {
		this.ordineDAO = ordineDAO;
	}
	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO)throws Exception {
		this.articoloDAO=articoloDAO;
	}

	@Override
	public List<Ordine> listaOrdine() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			ordineDAO.setEntityManager(entityManager);
			
			return ordineDAO.list();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Ordine leggiOrdine(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			ordineDAO.setEntityManager(entityManager);
			
			return ordineDAO.get(id);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiornaOrdine(Ordine input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			ordineDAO.setEntityManager(entityManager);
			
			ordineDAO.update(input);
			
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
	public void inserisciOrdine(Ordine input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			ordineDAO.setEntityManager(entityManager);
			
			ordineDAO.insert(input);
			
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
	public void elimminaOrdine(Long input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			ordineDAO.setEntityManager(entityManager);
			articoloDAO.setEntityManager(entityManager);
			
			if(articoloDAO.findAllByOrdine(input).size() > 0)
				throw new CustomException("errore ci sono articoli collegati");
			
			ordineDAO.delete(input);
			
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
	public List<Ordine> ordiniDiUnaCategoria(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			
			ordineDAO.setEntityManager(entityManager);
			
			return ordineDAO.allByThisCategoria(id);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Ordine prendiOrdinePiuRecenteDaCategoria(long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			
			ordineDAO.setEntityManager(entityManager);
			
			return ordineDAO.getOrdinePiuRecenteByCategoria(null);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<String> indirizzoDegliOrdiniContenentiNumeroSeriale(String stringaNumeroSeriale) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			
			ordineDAO.setEntityManager(entityManager);
			
			return ordineDAO.andressDegliOrdiniContenentiNumeroSeriale(stringaNumeroSeriale);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}


	
}
