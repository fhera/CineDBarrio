package aiss.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.restlet.engine.header.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

import aiss.client.APIService;
import aiss.shared.dominio.TMDB.serie.Serie;
import aiss.shared.dominio.TMDB.trailer.ListaTrailer;
import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.trakttv.LSeries;
import aiss.shared.dominio.trakttv.Traduccion;
import aiss.shared.dominio.trakttv.serie.Shows;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class APIServiceImpl extends RemoteServiceServlet implements APIService {

	private static final String TMDB_API_KEY = "08f0211eeab73ad077f12a6a627118f8";
	private static final String PLACE_API_KEY = "AIzaSyBNlZU09q-jlc79TF43mGFTEqfM8n94USk";
	private static final String TRAKTTV_API_KEY = "b3dd0f403bdd83ae3a465bcc958025f208a511afbcfde738757d877213ed8eeb";

	public Peliculas getPelisMejoresValoradas() {
		ClientResource cr = new ClientResource(
				"http://api.themoviedb.org/3/movie/top_rated?api_key="
						+ TMDB_API_KEY + "&language=es");
		Peliculas peli = cr.get(Peliculas.class);
		return peli;
	}

	public Collection<LSeries> getSeriesPopulares() {
		ClientResource cr = new ClientResource(
				"https://api-v2launch.trakt.tv/shows/trending");

		addHeader(cr, "Content-Type", "application/json");
		addHeader(cr, "trakt-api-version", "2");
		addHeader(cr, "trakt-api-key", TRAKTTV_API_KEY);
		LSeries[] series = cr.get(LSeries[].class);

		return Arrays.asList(series);
	}

	// Conseguir la info de cada serie
	public List<Serie> getSerie() {
		List<Serie> listSerie = new ArrayList<>();
		Serie serie = new Serie();
		Collection<LSeries> series = getSeriesPopulares();
		String tmdbID = null;

		for (LSeries ls : series) {
			tmdbID = ls.getShow().getIds().getTmdb().toString();
			ClientResource cr = new ClientResource(
					"http://api.themoviedb.org/3/tv/" + tmdbID + "?api_key="
							+ TMDB_API_KEY + "&laguange=es");

			serie = cr.get(Serie.class);
			listSerie.add(serie);
		}

		return listSerie;
	}
	
	public Collection<Shows> getSerieTrakt(String serie) {
		ClientResource cr = new ClientResource(
				"https://api-v2launch.trakt.tv/search?query=" + serie
						+ "&type=show");

		addHeader(cr, "Content-Type", "application/json");
		addHeader(cr, "trakt-api-version", "2");
		addHeader(cr, "trakt-api-key", TRAKTTV_API_KEY);
		Shows[] series = cr.get(Shows[].class);

		return Arrays.asList(series);
	}

	public Collection<LSeries> getBuscaSeries(String serie) {
		ClientResource cr = new ClientResource(
				"https://api-v2launch.trakt.tv/search?query=" + serie
						+ "&type=show");

		addHeader(cr, "Content-Type", "application/json");
		addHeader(cr, "trakt-api-version", "2");
		addHeader(cr, "trakt-api-key", TRAKTTV_API_KEY);
		LSeries[] series = cr.get(LSeries[].class);

		return Arrays.asList(series);
	}

	// Conseguir la info de cada serie
	public List<Serie> getBuscaSerie(String serie) {
		List<Serie> listSerie = new ArrayList<>();
		Collection<LSeries> series = getBuscaSeries(serie);
		String tmdbID = null;
		Serie s = new Serie();

		for (LSeries ls : series) {
			tmdbID = ls.getShow().getIds().getTmdb().toString();
			ClientResource cr = new ClientResource(
					"http://api.themoviedb.org/3/tv/" + tmdbID + "?api_key="
							+ TMDB_API_KEY + "&laguange=es");

			s = cr.get(Serie.class);
			listSerie.add(s);
		}

		return listSerie;
	}

	public Traduccion getSerieTraducida(String nombreSerie) {
		ClientResource cr = new ClientResource(
				"https://api-v2launch.trakt.tv/shows/" + nombreSerie
						+ "/translations/es");

		Traduccion trad = cr.get(Traduccion.class);
		return trad;
	}

	public Peliculas getPelisDeLaSemana() {
		ClientResource cr = new ClientResource(
				"http://api.themoviedb.org/3/movie/now_playing?api_key="
						+ TMDB_API_KEY + "&language=es");
		Peliculas peli = cr.get(Peliculas.class);
		return peli;
	}

	public Busqueda getBuscarMultimediaTMDB(String busqueda) {
		ClientResource cr = new ClientResource(
				"http://api.themoviedb.org/3/search/multi?api_key="
						+ TMDB_API_KEY + "&query=" + busqueda + "&language=es");
		Busqueda multi = cr.get(Busqueda.class);
		return multi;
	}

	public Multimedia getPelicula(Integer id) {
		ClientResource cr = new ClientResource(
				"http://api.themoviedb.org/3/movie/" + id + "?api_key="
						+ TMDB_API_KEY);
		Multimedia peli = cr.get(Multimedia.class);
		return peli;

	}

	public ListaTrailer getVideo(Integer id) {
		ClientResource cr = new ClientResource(
				"http://api.themoviedb.org/3/movie/" + id + "/videos?api_key="
						+ TMDB_API_KEY + "&language=es");
		ListaTrailer trailer = cr.get(ListaTrailer.class);
		return trailer;
	}

	public Cines getCinesCercanos() {
		ClientResource cr = new ClientResource(
				"https://maps.googleapis.com/maps/api/place/nearbysearch/json?key="
						+ PLACE_API_KEY
						+ "&location=37.35819,-5.98637&radius=5000&types=movie_theater");
		Cines cines = cr.get(Cines.class);
		return cines;
	}

	@SuppressWarnings("unchecked")
	private void addHeader(ClientResource cr, String key, String value) {
		Series<Header> headers = (Series<Header>) cr.getRequestAttributes()
				.get(HeaderConstants.ATTRIBUTE_HEADERS);
		if (headers == null) {
			headers = new Series<Header>(Header.class);
			cr.getRequestAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS,
					headers);
		}
		headers.add(key, value);
	}
}
