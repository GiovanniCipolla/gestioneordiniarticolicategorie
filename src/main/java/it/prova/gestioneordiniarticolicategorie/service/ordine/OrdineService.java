package it.prova.gestioneordiniarticolicategorie.service.ordine;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface OrdineService {

	public void setOrdineDAO(OrdineDAO ordineDAO) throws Exception;
	
	public void setArticoloDAO(ArticoloDAO articoloDAO)throws Exception;

	public List<Ordine> listaOrdine() throws Exception;

	public Ordine leggiOrdine(Long id) throws Exception;;

	public void aggiornaOrdine(Ordine input) throws Exception;

	public void inserisciOrdine(Ordine input) throws Exception;

	public void elimminaOrdine(Long input) throws Exception;
	
	public List<Ordine> ordiniDiUnaCategoria(Long id) throws Exception;
	
	public Ordine prendiOrdinePiuRecenteDaCategoria(long id) throws Exception;
	
	public List<String> indirizzoDegliOrdiniContenentiNumeroSeriale(String stringaNumeroSeriale) throws Exception;

}
