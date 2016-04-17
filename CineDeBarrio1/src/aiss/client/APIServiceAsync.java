package aiss.client;

import aiss.shared.dominio.tmdb.Pelicula;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface APIServiceAsync {

	void getPelisMejoresValoradas(AsyncCallback<Pelicula> callback);

}
