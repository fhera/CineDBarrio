package aiss.client.TMDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.client.APIService;
import aiss.client.APIServiceAsync;
import aiss.client.CineDeBarrio1;
import aiss.shared.dominio.TMDB.serie.Serie;
import aiss.shared.dominio.places.Cine;
import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.Pelicula;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TMDBView extends Composite {

	private final APIServiceAsync servicio = GWT.create(APIService.class);

	private final Button searchButton;
	private final TextBox searchField;
	private final Label etiquetaEstado;
	private final VerticalPanel searchPanel;
	private final FlexTable pelisPanel;
	private final FlexTable seriesPanel;

	public TMDBView() {

		// Panel principal e inicialización de la vista.
		searchPanel = new VerticalPanel();
		initWidget(searchPanel);

		pelisPanel = new FlexTable();
		seriesPanel = new FlexTable();
		searchButton = new Button("Buscar");
		searchField = new TextBox();
		etiquetaEstado = new Label();

		pelisPanel.getElement().setAttribute("id", "pelispanel");
		seriesPanel.getElement().setAttribute("id", "seriespanel");

		searchField.getElement().setAttribute("type", "text");
		searchField.getElement().setAttribute("id", "busqueda");
		searchField.getElement().setAttribute("placeholder", "Buscar aqui...");

		searchPanel.setStyleName("top_valoradas");

		searchButton.getElement().setAttribute("id", "busqueda");
		etiquetaEstado.getElement().setAttribute("id", "busqueda");

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

		searchField.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					etiquetaEstado.setText("Buscando...");

					final String busqueda = searchField.getText();

					RootPanel.get("top_valoradas").clear();
					RootPanel.get("peliculas").clear();
					RootPanel.get("mostrar_busqueda").clear();
					RootPanel.get("cines").clear();

					servicio.getBuscarMultimediaTMDB(busqueda,
							new AsyncCallback<Busqueda>() {

								@Override
								public void onFailure(Throwable caught) {
									Window.alert("Error en la busqueda de peliculas: "
											+ caught.getMessage());
								}

								@Override
								public void onSuccess(Busqueda result) {
									showMultimediaTMDB(busqueda, result);
									// searchField.setText("");
									// etiquetaEstado.setText("");
								}
							});
					// servicio.getSerie(busqueda,
					// new AsyncCallback<List<Serie>>() {
					//
					// @Override
					// public void onFailure(Throwable caught) {
					// Window.alert("Error en la busqueda de series: "
					// + caught.getMessage());
					// }
					//
					// @Override
					// public void onSuccess(List<Serie> result) {
					// // showSerieTrakttv(busqueda, result);
					// searchField.setText("");
					// etiquetaEstado.setText("");
					// }
					// });
				}
			}
		});

		searchButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				etiquetaEstado.setText("Buscando...");

				final String busqueda = searchField.getText();

				RootPanel.get("top_valoradas").clear();
				RootPanel.get("peliculas").clear();
				RootPanel.get("mostrar_busqueda").clear();
				RootPanel.get("cines").clear();

				servicio.getBuscarMultimediaTMDB(busqueda,
						new AsyncCallback<Busqueda>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Error en la busqueda: "
										+ caught.getMessage());
							}

							@Override
							public void onSuccess(Busqueda result) {
								showMultimediaTMDB(busqueda, result);
								searchField.setText("");
								etiquetaEstado.setText("");
							}
						});

				servicio.getCinesCercanos(new AsyncCallback<Cines>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Error en la busqueda de cines: "
								+ caught.getMessage());
					}

					@Override
					public void onSuccess(Cines result) {
						showCinesPlaces(result);
					}
				});
			}
		});

		searchPanel.add(etiquetaEstado);
		searchPanel.add(searchField);
		searchPanel.add(searchButton);
	}

	// A partir de aquí definimos los métodos para implementar las
	// funcionalidades
	private void showPeliculas(Peliculas peliculas) {
		final HorizontalPanel dock = new HorizontalPanel();
		Map<String, String> map = new HashMap<String, String>();
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
						// TODO Auto-generated method stub
						// RootPanel.get().clear();
						Window.alert(p.getTitle());
						CineDeBarrio1.go("pelicula");
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
		// RootPanel.get("top_valoradas").add(title);
		// RootPanel.get("top_valoradas").add(dock);
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

	private void showMultimediaTMDB(String busqueda, Busqueda result) {
		HTML title = new HTML("Busqueda en TMBD: " + busqueda);
		if (result != null) {
			for (int index = 0; index < 9; index++) {
				Multimedia multi = result.getResults().get(index);
				// Media_type: tv, movie
				if (multi.getTitle() == null) {
					pelisPanel.add(new HTML("<a href=>"
							+ "<img src=http://image.tmdb.org/t/p/w154"
							+ multi.getPoster_path() + ">" + "</a>"));
				} else
					pelisPanel.add(new HTML("<a href=>"
							+ "<img src=http://image.tmdb.org/t/p/w154"
							+ multi.getPoster_path() + ">" + "</a>"
							+ multi.getTitle()));
			}
		} else
			pelisPanel.add(new HTML("Sin resultados."));

		searchPanel.add(title);
		searchPanel.add(pelisPanel);
		// RootPanel.get("mostrar_busqueda").add(title);
		// RootPanel.get("mostrar_busqueda").add(indexTable);
	}

	private void showCinesPlaces(Cines result) {
		// TODO Auto-generated method stub

		String output = "<fieldset>";
		output += "<legend> Búsqueda de los cines </legend>";
		for (Cine c : result.getResults()) {
			if (c.getName().contains("Cine"))
				output += "<span><br>" + c.getName() + "</br></span>";
		}
		output += "</fieldset>";

		HTML cines = new HTML(output);

		RootPanel.get("cines").add(cines);

	}

}
