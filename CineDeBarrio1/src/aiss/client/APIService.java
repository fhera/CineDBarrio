package aiss.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

public interface APIService extends RemoteService {

	<Pelicula> void getPelisMejoresValoradas(AsyncCallback<Pelicula> callback);

}
S