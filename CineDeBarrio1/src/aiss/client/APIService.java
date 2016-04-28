package aiss.client;

import aiss.shared.dominio.tmdb.Pelicula;
import aiss.shared.dominio.tmdb.buscar.Result;
import aiss.shared.dominio.tmdb.buscar.Multimedia;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("servicio")
public interface APIService extends RemoteService {

	Pelicula getPelisMejoresValoradas();

	Multimedia getBuscarMultimediaTMDB(String busqueda);

	Result getPelicula(Integer id);

}
