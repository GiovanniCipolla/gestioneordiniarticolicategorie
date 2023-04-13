package it.prova.gestioneordiniarticolicategorie.service.ordine;

import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;

public class OrdineServiceImpl implements OrdineService{

	private OrdineDAO ordineDAO;

	@Override
	public void setOrdineDAO(OrdineDAO ordineDAO) throws Exception {
		this.ordineDAO = ordineDAO;
	}


	
}
