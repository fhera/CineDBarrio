package aiss.client;

import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.tviso.AuthToken;
import aiss.shared.dominio.tviso.BusquedaTviso;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface APIServiceAsync {

	void getPelisMejoresValoradas(AsyncCallback<Peliculas> callback);

	void getBuscarMultimediaTMDB(String busqueda,
			AsyncCallback<Busqueda> callback);

	void getPelicula(Integer id, AsyncCallback<Multimedia> callback);

	void getMediaPorTitulo(String titulo,
			AsyncCallback<BusquedaTviso> callback);
	void getAuthTokenTviso(AsyncCallback<AuthToken> callback);

	void getCinesCercanos(AsyncCallback<Cines> callback);

}
