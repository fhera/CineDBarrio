package aiss.client;

import aiss.shared.dominio.tmdb.Pelicula;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("api")
public interface APIService extends RemoteService {

	Pelicula getPelisMejoresValoradas();

}
