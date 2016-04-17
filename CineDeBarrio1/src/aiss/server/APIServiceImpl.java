package aiss.server;

import org.restlet.resource.ClientResource;

import aiss.client.APIService;
import aiss.shared.dominio.tmdb.Pelicula;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class APIServiceImpl extends RemoteServiceServlet implements APIService {

	@Override
	public Pelicula getPelisMejoresValoradas() {

		ClientResource cr = new ClientResource(
				"http://api.themoviedb.org/3/movie/top_rated?api_key=08f0211eeab73ad077f12a6a627118f8");

		Pelicula peli = cr.get(Pelicula.class);
		return peli;

	}

}
