package aiss.client;

import aiss.shared.dominio.tmdb;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("api")
public interface APIService extends RemoteService {

	void getPelisMejoresValoradas(AsyncCallback<Pelicula> callback);

}
