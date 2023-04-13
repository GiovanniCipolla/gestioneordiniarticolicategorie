package it.prova.gestioneordiniarticolicategorie.service.categoria;

import it.prova.gestioneordiniarticolicategorie.dao.categoria.CategoriaDAO;

public class CategoriaServiceImpl implements CategoriaService {
	
	private CategoriaDAO categoriaDAO;

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) throws Exception {
		this.categoriaDAO = categoriaDAO;
	}

	
	
}
