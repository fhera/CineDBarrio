package aiss.client;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import aiss.client.vistas.BusquedaView;
import aiss.client.vistas.PeliculaView;
import aiss.client.vistas.SerieView;
import aiss.client.vistas.MainView;
import aiss.client.vistas.VistaBase;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CineDeBarrio1 implements EntryPoint {

	HorizontalPanel menu = new HorizontalPanel();

	public void onModuleLoad() {
		go("init", new HashMap<String, Object>());
	}

	public static void go(String token) {
		CineDeBarrio1.go(token, new HashMap<String, Object>());
	}

	public static void go(String token, Map<String, Object> params) {
		Panel busqueda = RootPanel.get("busqueda");
		Panel body = RootPanel.get("body");
		if (token == "init") {
			busqueda.clear();
			body.clear();
			RootPanel.get().clear();

			busqueda.add(new VistaBase(params));
			body.add(new MainView(params));

		} else if (token == "busqueda") {
			body.clear();
			RootPanel.get().clear();
			body.add(new BusquedaView(params));

		} else if (token == "pelicula") {
			body.clear();
			RootPanel.get().clear();
			body.add(new PeliculaView(params));
		} else if (token == "serie") {
			body.clear();
			RootPanel.get().clear();
			body.add(new SerieView(params));
		}
	}
}
