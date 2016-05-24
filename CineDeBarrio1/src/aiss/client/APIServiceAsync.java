package aiss.client;

import java.util.Collection;

import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.trakttv.LSeries;
import aiss.shared.dominio.trakttv.busqueda.ListSeries;
import aiss.shared.dominio.tviso.AuthToken;
import aiss.shared.dominio.tviso.BusquedaTviso;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface APIServiceAsync {

	// TMDB
	void getPelisMejoresValoradas(AsyncCallback<Peliculas> callback);

	void getPelisDeLaSemana(AsyncCallback<Peliculas> callback);

	void getBuscarMultimediaTMDB(String busqueda,
			AsyncCallback<Busqueda> callback);

	void getPelicula(Integer id, AsyncCallback<Multimedia> callback);

	// Tviso
	void getMediaPorTitulo(String titulo, AsyncCallback<BusquedaTviso> callback);

	void getAuthTokenTviso(AsyncCallback<AuthToken> callback);

	// Google Place
	void getCinesCercanos(AsyncCallback<Cines> callback);

	// Trakt.tv
	void getSeries(String serie, AsyncCallback<Collection<ListSeries>> callback);

	void getSeriesPopulares(AsyncCallback<Collection<LSeries>> callback);

}
