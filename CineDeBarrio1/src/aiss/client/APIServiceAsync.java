package aiss.client;

import aiss.shared.dominio.tmdb.Pelicula;
import aiss.shared.dominio.tmdb.buscar.Multimedia;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface APIServiceAsync {

	void getPelisMejoresValoradas(AsyncCallback<Pelicula> callback);

	void getBuscarMultimediaTMDB(String busqueda, AsyncCallback<Multimedia> callback);

}
