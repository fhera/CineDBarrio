package aiss.client;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import aiss.client.TMDB.PeliculaView;
import aiss.client.TMDB.TMDBView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CineDeBarrio1 implements EntryPoint {

	HorizontalPanel menu = new HorizontalPanel();

	public void onModuleLoad() {
		go("init", new HashMap<String, String>());
	}

	public static void go(String token) {
		CineDeBarrio1.go(token, new HashMap<String, String>());
	}

	public static void go(String token, Map<String, String> params) {
		Panel p = RootPanel.get();
		if (token == "init") {
			p.clear();
			p.add(new TMDBView());
		} else if (token == "pelicula") {
//			p.clear();
			p.add(new PeliculaView());
		}
	}

}
