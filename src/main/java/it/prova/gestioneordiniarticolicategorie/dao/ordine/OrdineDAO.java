package it.prova.gestioneordiniarticolicategorie.dao.ordine;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine> {

	public List<Ordine> allByThisCategoria(Long id)throws Exception;
	
	public Ordine getOrdinePiuRecenteByCategoria(Long id) throws Exception;
	
	public List<String> andressDegliOrdiniContenentiNumeroSeriale(String stringaNumeroSeriale) throws Exception;
}
