package aiss.server;

import org.restlet.resource.ClientResource;

import aiss.client.APIService;
import aiss.shared.dominio.tmdb.Pelicula;
import aiss.shared.dominio.tmdb.buscar.Multimedia;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class APIServiceImpl extends RemoteServiceServlet implements APIService {
	
	private static final String TMDB_API_KEY= "08f0211eeab73ad077f12a6a627118f8";

	@Override
	public Pelicula getPelisMejoresValoradas() {

		ClientResource cr = new ClientResource(
				"http://api.themoviedb.org/3/movie/top_rated?api_key="+ TMDB_API_KEY);

		Pelicula peli = cr.get(Pelicula.class);
		return peli;

	}

	@Override
	public Multimedia getBuscarMultimedia(String busqueda) {

		ClientResource cr = new ClientResource(
				"http://api.themoviedb.org/3/search/multi?api_key="+ TMDB_API_KEY+ "&query="
						+ busqueda);
		Multimedia multi = cr.get(Multimedia.class);
		return multi;
	}

}
