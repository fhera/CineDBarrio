package aiss.client;

import java.util.Collection;
import java.util.List;

import aiss.shared.dominio.TMDB.serie.Serie;
import aiss.shared.dominio.TMDB.trailer.ListaTrailer;
import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.trakttv.LSeries;
import aiss.shared.dominio.trakttv.Traduccion;
import aiss.shared.dominio.trakttv.serie.Shows;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface APIServiceAsync {

	// TMDB
	void getPelisMejoresValoradas(AsyncCallback<Peliculas> callback);

	void getSerie(AsyncCallback<List<Serie>> callback);

	void getPelisDeLaSemana(AsyncCallback<Peliculas> callback);

	void getBuscarMultimediaTMDB(String busqueda,
			AsyncCallback<Busqueda> callback);

	void getVideo(Integer id, AsyncCallback<ListaTrailer> callback);

	void getBuscaSerie(String serie, AsyncCallback<List<Serie>> callback);

	// void getPelicula(Integer id, AsyncCallback<Multimedia> callback);

	// Google Place
	void getCinesCercanos(AsyncCallback<Cines> callback);

	// Trakt.tv
	void getSeriesPopulares(AsyncCallback<Collection<LSeries>> callback);

	void getSerieTrakt(String serie, AsyncCallback<Collection<Shows>> callback);

	void getSerieTraducida(String nombreSerie,
			AsyncCallback<Traduccion> callback);

}
