package aiss.client.vistas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.client.APIService;
import aiss.client.APIServiceAsync;
import aiss.client.CineDeBarrio1;
import aiss.shared.dominio.TMDB.serie.Serie;
import aiss.shared.dominio.tmdb.Pelicula;
import aiss.shared.dominio.tmdb.Peliculas;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TMDBView extends Composite {

	private final APIServiceAsync servicio = GWT.create(APIService.class);

	private final VerticalPanel searchPanel;
	private final FlexTable pelisPanel;
	private final FlexTable seriesPanel;

	public TMDBView(Map<String, Object> params) {

		// Panel principal e inicialización de la vista.
		searchPanel = new VerticalPanel();
		initWidget(searchPanel);

		pelisPanel = new FlexTable();
		seriesPanel = new FlexTable();

		pelisPanel.getElement().setAttribute("id", "pelispanel");
		seriesPanel.getElement().setAttribute("id", "seriespanel");

		searchPanel.setStyleName("top_valoradas");

		servicio.getSerie(new AsyncCallback<List<Serie>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Errores en la carga de las series: "
						+ caught.getMessage());
			}

			@Override
			public void onSuccess(List<Serie> listSeries) {
				showSeries(listSeries);
			}
		});
		servicio.getPelisDeLaSemana(new AsyncCallback<Peliculas>() {
			@Override
			public void onSuccess(Peliculas peliculas) {
				showPeliculas(peliculas);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Errores en la carga de las peliculas: "
						+ caught.getMessage());
			}
		});
	}

	// A partir de aquí definimos los métodos para implementar las
	// funcionalidades
	private void showPeliculas(Peliculas peliculas) {

		final HorizontalPanel dock = new HorizontalPanel();
		Map<String, Object> map = new HashMap<String, Object>();

		Image poster = new Image();
		HTML title = new HTML("Películas actuales: ");
		title.getElement().setAttribute("id", "titulo");

		if (peliculas != null) {
			for (int index = 0; index < 9; index++) {
				final Pelicula p = peliculas.getResults().get(index);

				poster.setUrl("http://image.tmdb.org/t/p/w154"
						+ p.getPoster_path());
				poster.setTitle(p.getId() + "");

				HTML h = new HTML(poster + p.getTitle());

				h.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						CineDeBarrio1.go("pelicula",
								new HashMap<String, Object>());
					}
				});

				dock.add(h);

				map.put("Pelicula", poster.getTitle() + "");
				// CineDeBarrio1.go("pelicula");
			}
		} else
			new HTML(
					"<span> Hay algun que otro problema, lo resolveremos lo antes posible</span>");

		searchPanel.add(title);
		searchPanel.add(dock);
	}

	private void showSeries(List<Serie> listSeries) {
		HTML title = new HTML("Series actuales: ");
		title.getElement().setAttribute("id", "titulo");

		int index = 0;
		if (listSeries != null) {
			for (final Serie serie : listSeries) {
				if (index < 9) {
					Image poster = new Image();
					poster.setUrl("http://image.tmdb.org/t/p/w154"
							+ serie.getPoster_path());

					HTML h = new HTML(poster + "");

					h.addClickHandler(new ClickHandler() {

						@Override
						public void onClick(ClickEvent event) {
							serie.getName();
						}
					});

					seriesPanel.setHTML(0, index, h + "");
					seriesPanel.setHTML(1, index, serie.getName());
					index++;
				}
			}
		}
		searchPanel.add(title);
		searchPanel.add(seriesPanel);
	}

}
