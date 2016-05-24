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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("servicio")
public interface APIService extends RemoteService {
	// TMDB
	Peliculas getPelisMejoresValoradas();

	Peliculas getPelisDeLaSemana();

	Busqueda getBuscarMultimediaTMDB(String busqueda);

	Multimedia getPelicula(Integer id);

	// TViso
	BusquedaTviso getMediaPorTitulo(String titulo);

	AuthToken getAuthTokenTviso();

	// Trakt.tv
	Collection<LSeries> getSeriesPopulares();

	Collection<ListSeries> getSeries(String serie);

	// GooglePlaces
	Cines getCinesCercanos();
}
