package aiss.client;

import aiss.shared.dominio.tmdb.Pelicula;
import aiss.shared.dominio.tmdb.buscar.Result;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.tviso.Media;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface APIServiceAsync {

	void getPelisMejoresValoradas(AsyncCallback<Pelicula> callback);

	void getBuscarMultimediaTMDB(String busqueda,
			AsyncCallback<Multimedia> callback);

	void getPelicula(Integer id, AsyncCallback<Result> callback);

	void getMediaPorTitulo(String titulo, AsyncCallback<Media> callback);

}
