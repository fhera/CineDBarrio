package aiss.client;

import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.trakttv.ListSeries;
import aiss.shared.dominio.tviso.AuthToken;
import aiss.shared.dominio.tviso.BusquedaTviso;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("servicio")
public interface APIService extends RemoteService {
	// TMDB
	Peliculas getPelisMejoresValoradas();

	Busqueda getBuscarMultimediaTMDB(String busqueda);

	Multimedia getPelicula(Integer id);

	// TViso
	BusquedaTviso getMediaPorTitulo(String titulo);

	AuthToken getAuthTokenTviso();

	ListSeries getSerie(String serie);

	// GooglePlaces
	Cines getCinesCercanos();
}
