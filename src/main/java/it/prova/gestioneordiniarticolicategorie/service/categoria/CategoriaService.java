package it.prova.gestioneordiniarticolicategorie.service.categoria;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface CategoriaService {

	public void setCategoriaDAO(CategoriaDAO categoriaDAO) throws Exception;
	public void setArticoloDAO(ArticoloDAO articoloDAO)  throws Exception;
	
	public List<Categoria> listaCatgegoria() throws Exception;
	
	public Categoria leggiCategoria(Long id) throws Exception;;
	
	public void aggiornaCategoria(Categoria input) throws Exception;
	
	public void inserisciCategoria(Categoria input) throws Exception;
	
	public void elimminaCategoria(Categoria input) throws Exception;
	
	public void aggiungiArticoloACategoria(Articolo articoloInput,Categoria categoriaInput) throws Exception;

	public void rimozioneCategoriaDaScollegareAArticolo(Long id)throws Exception ;

	public List<Categoria> categoriaDiUnOrdine(Long id) throws Exception;
	




}
