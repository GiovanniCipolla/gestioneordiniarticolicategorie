package it.prova.gestioneordiniarticolicategorie.dao.categoria;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {

	public void removeCategoriaUnlinkArticolo(Long id) throws Exception;
	
	public List<Categoria> allByThisOrdine(Long id)throws Exception;
	
	public List<Categoria> findDistinctCategorieByOrdine(Long idOrdine) throws Exception;
}
