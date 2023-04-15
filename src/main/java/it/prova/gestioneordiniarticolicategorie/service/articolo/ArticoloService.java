package it.prova.gestioneordiniarticolicategorie.service.articolo;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface ArticoloService {

	public void setArticoloDAO(ArticoloDAO articoloDAO) throws Exception;
	
	public List<Articolo> listaArticolo() throws Exception;
	
	public Articolo leggiArticolo(Long id) throws Exception;;
	
	public void aggiornaArticolo(Articolo input) throws Exception;
	
	public void inserisciArticolo(Articolo input) throws Exception;
	
	public void elimminaArticolo(Articolo input) throws Exception;
	
	public void aggiungiCategoriaAArticolo(Articolo articoloInput,Categoria categoriaInput) throws Exception;

	public void rimozioneArticoloDaScollegareACategoria(Long id)throws Exception ;

	public  int sommaPrezzoArticoliDiCategoria(Long id) throws Exception;
	
}
