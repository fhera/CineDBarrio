package aiss.server;

import org.restlet.resource.ClientResource;
import aiss.client.APIService;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.tviso.AuthToken;
import aiss.shared.dominio.tviso.BusquedaTviso;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class APIServiceImpl extends RemoteServiceServlet implements APIService {

	private static final String TMDB_API_KEY = "08f0211eeab73ad077f12a6a627118f8";
	private static final String TVISO_API_ID = "3486";
	private static final String TVISO_SECRET = "sFpnqqvtASHvWPKFANZn";

	// Url para rescatar todas las imagenes de una peli.
	// https://api.themoviedb.org/3/movie/{id}/images?api_key=###&language=en&include_image_language=es

	// Para ver el trailer en youtube:
	// https://www.youtube.com/watch?v={key}
	// https://api.themoviedb.org/3/movie/550?api_key=08f0211eeab73ad077f12a6a627118f8&append_to_response=releases,trailers

	public Peliculas getPelisMejoresValoradas() {
		ClientResource cr = new ClientResource(
				"http://api.themoviedb.org/3/movie/top_rated?api_key="
						+ TMDB_API_KEY);
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

	// Creo que esta mal, porque yo no quiero un AuthToken, quiero solo la String authToken de esa clase.
	// PREGUNTAR!!
	public BusquedaTviso getMediaPorTitulo(String titulo) {
		AuthToken auth = getAuthTokenTviso();
		String token = auth.getAuth_token(); 
		ClientResource cr = new ClientResource(
				"https://api.tviso.com/media/search?auth_token=" + token
						+ "&q=" + titulo);
		BusquedaTviso media = cr.get(BusquedaTviso.class);
		return media;
	}

	// De aqui deberia de sacar dicha String authToken.
	public AuthToken getAuthTokenTviso() {
		ClientResource cr = new ClientResource(
				"https://api.tviso.com/auth_token?id_api=" + TVISO_API_ID + "&secret="
						+ TVISO_SECRET);
		AuthToken authToken = cr.get(AuthToken.class);
		return authToken;
	}

}
