package aiss.client;

import java.util.Collection;
import java.util.List;

import aiss.shared.dominio.TMDB.serie.Serie;
import aiss.shared.dominio.TMDB.trailer.ListaTrailer;
import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.trakttv.LSeries;
import aiss.shared.dominio.trakttv.Traduccion;
import aiss.shared.dominio.trakttv.serie.Shows;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("servicio")
public interface APIService extends RemoteService {
	// TMDB
	Peliculas getPelisMejoresValoradas();

	List<Serie> getSerie();

	Peliculas getPelisDeLaSemana();

	Busqueda getBuscarMultimediaTMDB(String busqueda);

	List<Serie> getBuscaSerie(String serie);

	// Multimedia getPelicula(Integer id);

	ListaTrailer getVideo(Integer id);

	// Trakt.tv
	Collection<LSeries> getSeriesPopulares();

	Collection<Shows> getSerieTrakt(String serie);

	Traduccion getSerieTraducida(String nombreSerie);

	// GooglePlaces
	Cines getCinesCercanos();
}
