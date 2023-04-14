package it.prova.gestioneordiniarticolicategorie.service.categoria;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public class CategoriaServiceImpl implements CategoriaService {
	
	private CategoriaDAO categoriaDAO;
	private ArticoloDAO articoloDAO;	
	
	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) throws Exception {
		this.articoloDAO=articoloDAO;		
	}
	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) throws Exception {
		this.categoriaDAO = categoriaDAO;
	}

	@Override
	public List<Categoria> listaCatgegoria() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			categoriaDAO.setEntityManager(entityManager);
			
			return categoriaDAO.list();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Categoria leggiCategoria(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			categoriaDAO.setEntityManager(entityManager);
			
			return categoriaDAO.get(id);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiornaCategoria(Categoria input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			categoriaDAO.setEntityManager(entityManager);
			
			categoriaDAO.update(input);
			
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
	public void inserisciCategoria(Categoria input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			categoriaDAO.setEntityManager(entityManager);
			
			categoriaDAO.insert(input);
			
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
	public void elimminaCategoria(Categoria input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			categoriaDAO.setEntityManager(entityManager);
			
			categoriaDAO.delete(input);
			
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
	public void aggiungiArticoloACategoria(Articolo articoloInput, Categoria categoriaInput) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			categoriaDAO.setEntityManager(entityManager);
			articoloDAO.setEntityManager(entityManager);
			
			articoloInput = entityManager.merge(articoloInput);
			categoriaInput = entityManager.merge(categoriaInput);
			
			categoriaInput.getArticoli().add(articoloInput);
			
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
	public void rimozioneCategoriaDaScollegareAArticolo(Long id) throws Exception {
			EntityManager entityManager = EntityManagerUtil.getEntityManager();
			try {
				entityManager.getTransaction().begin();
				categoriaDAO.setEntityManager(entityManager);
				
				
				categoriaDAO.removeCategoriaUnlinkArticolo(id);
				
				entityManager.getTransaction().commit();
			}catch (Exception e) {
				entityManager.getTransaction().rollback();
				e.printStackTrace();
				throw e;
			} finally {
				EntityManagerUtil.closeEntityManager(entityManager);
			}
			
		
	}


	
	
}
