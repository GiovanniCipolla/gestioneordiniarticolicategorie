package it.prova.gestioneordiniarticolicategorie.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;
import it.prova.gestioneordiniarticolicategorie.service.MyServiceFactory;
import it.prova.gestioneordiniarticolicategorie.service.articolo.ArticoloService;
import it.prova.gestioneordiniarticolicategorie.service.categoria.CategoriaService;
import it.prova.gestioneordiniarticolicategorie.service.ordine.OrdineService;

public class TestGestioneordiniarticolicategorie {

	public static void main(String[] args) throws Exception {
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
		try {

			// --------------------------- INIZIO TEST -----------------------

//			testInserisciOrdine(ordineServiceInstance);
//			testAggiornaOrdine(ordineServiceInstance);
//			testInsericiArticolo(articoloServiceInstance, ordineServiceInstance);
//			testAggiornaArticolo(articoloServiceInstance);
//			testRimuoviArticolo(articoloServiceInstance);
//			testInsericiCategoria(categoriaServiceInstance);
//			testAggiornaCategoria(categoriaServiceInstance);
//			rimozioneCategoriaDaScollegareAArticolo(categoriaServiceInstance);
//			rimozioneArticoloDaScollegareACategoria(articoloServiceInstance);
//			testCategoriaDiUnOrdine(ordineServiceInstance, categoriaServiceInstance);
//			testOrdiniDiUnaCategoria(ordineServiceInstance, categoriaServiceInstance);
//			prendiListaDistintaCategoriaByOrdine(ordineServiceInstance, categoriaServiceInstance);
//			testIndirizzoDegliOrdiniContenentiNumeroSeriale(ordineServiceInstance, articoloServiceInstance);
//			testAggiungiCategoriaAArticolo(categoriaServiceInstance, articoloServiceInstance);
			
			
			
			
			// ------------DA VEDERE MEGLIO
//			testPrendiOrdinePiuRecenteDaCategoria(ordineServiceInstance, categoriaServiceInstance);
//			testRimuoviOrdineConCustom(ordineServiceInstance); 
//			testAggiungiArticoloACategoria(categoriaServiceInstance, articoloServiceInstance);
//			testSommaPrezzoArticoliDiCategoria(articoloServiceInstance, categoriaServiceInstance);
//			testSommaPrezziArticoliDiUnDestinatario(ordineServiceInstance, articoloServiceInstance);
			// -----------------------------------------------------------------------------------




			
			
//			testListaArticoliConErroriInOrdine(articoloServiceInstance);
			

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

	public static void testInserisciOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------------ testInserisciOrdine INIZIO ----------------- ");

		int indiceControllo = ordineServiceInstance.listaOrdine().size();

		Ordine ordineDaInserire = new Ordine("Lorenzo", "via Branca", LocalDate.parse("2023-07-21"));

		ordineServiceInstance.inserisciOrdine(ordineDaInserire);

		int indiceControlloAggiornato = ordineServiceInstance.listaOrdine().size();

		if (indiceControllo == indiceControlloAggiornato)
			throw new Exception("test failed : inserimento non riuscito");

		System.out.println("------------------ testInserisciOrdine FINE ----------------- ");
	}

	public static void testAggiornaOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------------ testAggiornaOrdine INIZIO ----------------- ");

		List<Ordine> ordiniPresenti = ordineServiceInstance.listaOrdine();

		if (ordiniPresenti.isEmpty())
			throw new RuntimeException("test failed: non esistono ordini");

		Ordine ordineDaModificare = ordineServiceInstance.listaOrdine().get(0);

		ordineDaModificare.setIndirizzoSpedizione("via Brancamenta");

		ordineServiceInstance.aggiornaOrdine(ordineDaModificare);

		Ordine ordineModificato = ordineServiceInstance.listaOrdine().get(0);

		if (ordineDaModificare.equals(ordineModificato))
			throw new RuntimeException("test failed: errore nell'aggiornamento");

		System.out.println("------------------ testAggiornaOrdine FINE ----------------- ");
	}

	public static void testInsericiArticolo(ArticoloService articoloServiceInstance,
			OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------------ testInsericiArticolo INIZIO ----------------- ");

		int indiceControllo = articoloServiceInstance.listaArticolo().size();

		Articolo articoloDaInserire = new Articolo("mozzarelle", "ab01", 5, LocalDate.parse("2023-04-10"));

		articoloDaInserire.setOrdine(ordineServiceInstance.listaOrdine().get(0));

		articoloServiceInstance.inserisciArticolo(articoloDaInserire);

		int indiceControlloAggiornato = articoloServiceInstance.listaArticolo().size();

		if (indiceControllo == indiceControlloAggiornato)
			throw new Exception("test failed : errore nell'inserimento");

		System.out.println("------------------ testInsericiArticolo FINE ----------------- ");
	}

	public static void testAggiornaArticolo(ArticoloService articoloServiceInstance) throws Exception {
		System.out.println("------------------ testAggiornaArticolo INIZIO ----------------- ");

		List<Articolo> articoliPresenti = articoloServiceInstance.listaArticolo();

		if (articoliPresenti.isEmpty())
			throw new RuntimeException("test failed: non esistono articoli");

		Articolo articoloDaModificare = articoliPresenti.get(0);

		articoloDaModificare.setDescrizione("patate");

		articoloServiceInstance.aggiornaArticolo(articoloDaModificare);

		Articolo articoloModificato = articoloServiceInstance.listaArticolo().get(0);

		if (articoloDaModificare.equals(articoloModificato))
			throw new Exception("test failed: errore nell'aggiornamento");

		System.out.println("------------------ testAggiornaArticolo FINE ----------------- ");
	}

	public static void testRimuoviArticolo(ArticoloService articoloServiceInstance) throws Exception {
		System.out.println("------------------ testRimuoviArticolo INIZIO ----------------- ");

		int indiceControllo = articoloServiceInstance.listaArticolo().size();

		Long articoloDaEliminare = articoloServiceInstance.listaArticolo().get(0).getId();;

		articoloServiceInstance.elimminaArticolo(articoloDaEliminare);

		int indiceControlloAggiornato = articoloServiceInstance.listaArticolo().size();

		if (indiceControlloAggiornato == indiceControllo)
			throw new RuntimeException("test failed: errore nella rimozione");

		System.out.println("------------------ testRimuoviArticolo FINE ----------------- ");
	}

	public static void testInsericiCategoria(CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------------ testInsericiArticolo INIZIO ----------------- ");

		int indiceControllo = categoriaServiceInstance.listaCatgegoria().size();

		Categoria categoriaDaInserire = new Categoria("alimenti", "a1");

		categoriaServiceInstance.inserisciCategoria(categoriaDaInserire);

		int indiceControlloAggiornato = categoriaServiceInstance.listaCatgegoria().size();

		if (indiceControllo == indiceControlloAggiornato)
			throw new Exception("test failed : errore nell'inserimento");

		System.out.println("------------------ testInsericiArticolo FINE ----------------- ");
	}

	public static void testAggiornaCategoria(CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------------ testAggiornaCategoria INIZIO ----------------- ");

		Categoria categoriaDaAggiornare = categoriaServiceInstance.listaCatgegoria().get(0);

		categoriaDaAggiornare.setCodice("al01");

		categoriaServiceInstance.aggiornaCategoria(categoriaDaAggiornare);

		Categoria categoriaAggiornata = categoriaServiceInstance.listaCatgegoria().get(0);

		if (categoriaAggiornata.equals(categoriaDaAggiornare))
			throw new Exception("test failed : errore nell'aggiornamento");

		System.out.println("------------------ testAggiornaCategoria FINE ----------------- ");
	}

	public static void testAggiungiCategoriaAArticolo(CategoriaService categoriaServiceInstance,
			ArticoloService articoloServiceInstance) throws Exception {
		System.out.println("------------------ testAggiungiCategoriaAArticolo INIZIO ----------------- ");

		Categoria categoriaDaAggiungere = categoriaServiceInstance.listaCatgegoria().get(0);

		Articolo articoloDaPrendere = articoloServiceInstance.listaArticolo().get(0);

//		int indiceControllo = articoloDaPrendere.getCategorie().size();

		articoloServiceInstance.aggiungiCategoriaAArticolo(articoloDaPrendere, categoriaDaAggiungere);

		Articolo articoloAggiornato = articoloServiceInstance.listaArticolo().get(0);

//		int indiceControlloAggiornato = articoloAggiornato.getCategorie().size();

//		if (indiceControllo == indiceControlloAggiornato)
//			throw new RuntimeException("test failed : errore nell'aggiungere");

		System.out.println("------------------ testAggiungiCategoriaAArticolo FINE ----------------- ");
	}

	public static void testAggiungiArticoloACategoria(CategoriaService categoriaServiceInstance,
			ArticoloService articoloServiceInstance) throws Exception {
		System.out.println("------------------ testAggiungiCategoriaAArticolo INIZIO ----------------- ");

		Articolo articoloDaAggiungere = articoloServiceInstance.listaArticolo().get(0);

		Categoria categoriaDaPrendere = categoriaServiceInstance.listaCatgegoria().get(0);

//		int indiceControllo = categoriaDaPrendere.getArticoli().size();

		categoriaServiceInstance.aggiungiArticoloACategoria(articoloDaAggiungere, categoriaDaPrendere);

		Categoria categoriaDaPrendereAggiornata = categoriaServiceInstance.listaCatgegoria().get(0);

//		int indiceControlloAggiornato = categoriaDaPrendereAggiornata.getArticoli().size();

//		if (indiceControllo == indiceControlloAggiornato)
//			throw new RuntimeException("test failed : errore nell'aggiungere");

		System.out.println("------------------ testAggiungiCategoriaAArticolo FINE ----------------- ");
	}

	public static void rimozioneArticoloDaScollegareACategoria(ArticoloService articoloServiceInstance)
			throws Exception {
		System.out.println("------------------ rimozioneArticoloDaScollegareACategoria INIZIO ----------------- ");

		Articolo articoloDaEliminare = articoloServiceInstance.listaArticolo().get(0);

		Long idDaPrendere = articoloDaEliminare.getId();

		int indiceControllo = articoloServiceInstance.listaArticolo().size();

		articoloServiceInstance.rimozioneArticoloDaScollegareACategoria(idDaPrendere);

		int indiceControlloAggiornato = articoloServiceInstance.listaArticolo().size();

		if (indiceControllo == indiceControlloAggiornato)
			throw new RuntimeException("test failed : errore nella eliminazione");

		System.out.println("------------------ rimozioneArticoloDaScollegareACategoria FINE ----------------- ");
	}

	public static void rimozioneCategoriaDaScollegareAArticolo(CategoriaService categoriaServiceInstance)
			throws Exception {
		System.out.println("------------------ rimozioneCategoriaDaScollegareAArticolo INIZIO ----------------- ");

		Categoria articoloDaEliminare = categoriaServiceInstance.listaCatgegoria().get(0);
		Long idDaPrendere = articoloDaEliminare.getId();

		int indiceControllo = categoriaServiceInstance.listaCatgegoria().size();

		categoriaServiceInstance.rimozioneCategoriaDaScollegareAArticolo(idDaPrendere);

		int indiceControlloAggiornato = categoriaServiceInstance.listaCatgegoria().size();

		if (indiceControllo == indiceControlloAggiornato)
			throw new RuntimeException("test failed : errore nella eliminazione");

		System.out.println("------------------ rimozioneCategoriaDaScollegareAArticolo FINE ----------------- ");
	}

	private static void testRimuoviOrdineConCustom(OrdineService ordineServiceInstance) throws Exception {
		System.out.println("------------------ testRimuoviOrdineConCustom INIZIO ----------------- ");

		Long ordineDaRimuovere = ordineServiceInstance.listaOrdine().get(0).getId();

//		int i = ordineServiceInstance.listaOrdine().size();

		ordineServiceInstance.elimminaOrdine(ordineDaRimuovere);

//		int j = ordineServiceInstance.listaOrdine().size();

//		if (i == j)
//			throw new RuntimeException("test failed: errore nella rimozione");

		System.out.println("------------------ testRimuoviOrdineConCustom FINE ----------------- ");

	}

	private static void testOrdiniDiUnaCategoria(OrdineService ordineServiceInstance,
			CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------------ testOrdiniDiUnaCategoria INIZIO ----------------- ");

		Long idDaPrendere = categoriaServiceInstance.listaCatgegoria().get(0).getId();

		List<Ordine> result = ordineServiceInstance.ordiniDiUnaCategoria(idDaPrendere);

		if (result.isEmpty())
			throw new RuntimeException("test failed: nessun ordine disponibile");

		System.out.println(result);

		System.out.println("------------------ testOrdiniDiUnaCategoria FINE ----------------- ");
	}

	private static void testCategoriaDiUnOrdine(OrdineService ordineServiceInstance,
			CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------------ testCategoriaDiUnOrdine INIZIO ----------------- ");

		Long idDaPrendere = ordineServiceInstance.listaOrdine().get(0).getId();
		List<Categoria> result = categoriaServiceInstance.categoriaDiUnOrdine(idDaPrendere);

		System.out.println(result);

		System.out.println("------------------ testCategoriaDiUnOrdine FINE ----------------- ");
	}

	private static void testSommaPrezzoArticoliDiCategoria(ArticoloService articoloServiceInsetance,
			CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------------ testSommaPrezzoArticoliDiCategoria INIZIO ----------------- ");

		Long idDaPrendere = categoriaServiceInstance.listaCatgegoria().get(0).getId();

		int result = articoloServiceInsetance.sommaPrezzoArticoliDiCategoria(idDaPrendere);

		System.out.println(result);

		System.out.println("------------------ testSommaPrezzoArticoliDiCategoria FINE ----------------- ");
	}

	private static void testPrendiOrdinePiuRecenteDaCategoria(OrdineService ordineServiceInsetance,
			CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------------ testPrendiOrdinePiuRecenteDaCategoria INIZIO ----------------- ");

		Long idDaPrendere = categoriaServiceInstance.listaCatgegoria().get(0).getId();

		Ordine result = ordineServiceInsetance.prendiOrdinePiuRecenteDaCategoria(idDaPrendere);

		System.out.println(result.getNomeDestinatario());

		System.out.println("------------------ testPrendiOrdinePiuRecenteDaCategoria FINE ----------------- ");
	}

	private static void prendiListaDistintaCategoriaByOrdine(OrdineService ordineServiceInsetance,
			CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println("------------------ prendiListaDistintaCategoriaByOrdine INIZIO ----------------- ");

		Long idDaPrendere = ordineServiceInsetance.listaOrdine().get(0).getId();

		List<Categoria> result = categoriaServiceInstance.prendiListaDistintaCategoriaByOrdine(idDaPrendere);

		System.out.println(result);

		System.out.println("------------------ prendiListaDistintaCategoriaByOrdine FINE ----------------- ");
	}

	private static void testSommaPrezziArticoliDiUnDestinatario(OrdineService ordineServiceInsetance,
			ArticoloService articoloServiceInstance) throws Exception {
		System.out.println("------------------ testSommaPrezziArticoliDiUnDestinatario INIZIO ----------------- ");
		
		String stringDaPrendere = ordineServiceInsetance.listaOrdine().get(0).getNomeDestinatario();
		
		Long result = articoloServiceInstance.sommaPrezziArticoliDiUnDestinatario(stringDaPrendere);
		
		System.out.println(result);
		
		System.out.println("------------------ testSommaPrezziArticoliDiUnDestinatario FINE ----------------- ");
		
	}
	
	private static void testIndirizzoDegliOrdiniContenentiNumeroSeriale(OrdineService ordineServiceInsetance,
			ArticoloService articoloServiceInstance) throws Exception {
		
		System.out.println("------------------ testIndirizzoDegliOrdiniContenentiNumeroSeriale INIZIO ----------------- ");
		
		String nSeriale = articoloServiceInstance.listaArticolo().get(0).getNumeroSeriale();
		
		List<String> result = ordineServiceInsetance.indirizzoDegliOrdiniContenentiNumeroSeriale(nSeriale);
		
		System.out.println(result);
		
		
		System.out.println("------------------ testIndirizzoDegliOrdiniContenentiNumeroSeriale FINE ----------------- ");
	}
	
	private static void testListaArticoliConErroriInOrdine(ArticoloService articoloServiceInstance) throws Exception{
		System.out.println("------------------ testIndirizzoDegliOrdiniContenentiNumeroSeriale INIZIO ----------------- ");
		
		List<Articolo> result = articoloServiceInstance.listaArticoliConErroriInOrdine();
		
		System.out.println(result);
		
		
		System.out.println("------------------ testIndirizzoDegliOrdiniContenentiNumeroSeriale FINE ----------------- ");
	}

}
