package it.prova.gestioneordiniarticolicategorie.service.ordine;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface OrdineService {

	public void setOrdineDAO(OrdineDAO ordineDAO) throws Exception;

	public List<Ordine> listaOrdine() throws Exception;

	public Ordine leggiOrdine(Long id) throws Exception;;

	public void aggiornaOrdine(Ordine input) throws Exception;

	public void inserisciOrdine(Ordine input) throws Exception;

	public void elimminaOrdine(Ordine input) throws Exception;

}
