package it.prova.gestioneordiniarticolicategorie.dao.articolo;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;

public interface ArticoloDAO extends IBaseDAO<Articolo> {

	public void removeArticoloUnlinkCategoria(Long id) throws Exception;

	public int sumPriceArticoliDiCategroia(Long id)throws Exception;
	
	public Long sumPriceArticoliByDestinatario(String nomeDestinatario) throws Exception;
	
	public List<Articolo> listArticoliWithErroriInOrdine() throws Exception;
	
	public List<Articolo> findAllByOrdine(Long idOrdine) throws Exception;
}
