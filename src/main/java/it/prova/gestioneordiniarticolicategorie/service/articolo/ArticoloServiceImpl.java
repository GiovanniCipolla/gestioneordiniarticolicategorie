package it.prova.gestioneordiniarticolicategorie.service.articolo;


import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;

public class ArticoloServiceImpl implements ArticoloService {
	
	private ArticoloDAO articoloDAO;

	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) throws Exception {
		this.articoloDAO = articoloDAO;
	}


	
	
	
}
