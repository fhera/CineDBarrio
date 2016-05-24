package aiss.client.TMDB;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.client.APIService;
import aiss.client.APIServiceAsync;
import aiss.shared.dominio.places.Cine;
import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.Pelicula;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.trakttv.LSeries;
import aiss.shared.dominio.trakttv.busqueda.ListSeries;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
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

public class TMDBView extends Composite {

	private final APIServiceAsync servicio = GWT.create(APIService.class);

	private final Button searchButton = new Button("Buscar");
	private final TextBox searchField = new TextBox();
	private final Label etiquetaEstado = new Label();
	private final HorizontalPanel searchPanel = new HorizontalPanel();

	public TMDBView() {

		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		searchPanel.add(etiquetaEstado);

		searchField.getElement().setAttribute("type", "text");
		searchField.getElement().setAttribute("id", "busqueda");
		searchField.getElement().setAttribute("placeholder", "Buscar aqui...");

		searchButton.getElement().setAttribute("id", "busqueda");
		etiquetaEstado.getElement().setAttribute("id", "busqueda");

		RootPanel.get("busqueda").add(searchPanel);

		servicio.getSeriesPopulares(new AsyncCallback<Collection<LSeries>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(Collection<LSeries> result) {
				showSeries(result);
			}
		});
		servicio.getPelisDeLaSemana(new AsyncCallback<Peliculas>() {
			@Override
			public void onSuccess(Peliculas peliculas) {
				showPeliculas(peliculas);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
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
									Window.alert("Error en la busqueda: "
											+ caught.getMessage());
								}

								@Override
								public void onSuccess(Busqueda result) {
									showMultimediaTMDB(busqueda, result);
									// searchField.setText("");
									// etiquetaEstado.setText("");
								}
							});
					servicio.getSeries(busqueda,
							new AsyncCallback<Collection<ListSeries>>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									Window.alert("No es una serie.");
								}

								@Override
								public void onSuccess(
										Collection<ListSeries> result) {
									// TODO Auto-generated method stub
									showSerieTrakttv(busqueda, result);
									searchField.setText("");
									etiquetaEstado.setText("");
								}
							});
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
				// servicio.getMediaPorTitulo(busqueda,
				// new AsyncCallback<BusquedaTviso>() {
				//
				// @Override
				// public void onFailure(Throwable caught) {
				// // TODO Auto-generated method stub
				// Window.alert("Error en la busqueda: "
				// + caught.getMessage());
				//
				// }
				//
				// @Override
				// public void onSuccess(BusquedaTviso result) {
				// // TODO Auto-generated method stub
				// showMediaTViso(busqueda, result);
				// searchField.setText("");
				// etiquetaEstado.setText("");
				// }
				// });
				servicio.getCinesCercanos(new AsyncCallback<Cines>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("Error en la busqueda: "
								+ caught.getMessage());
					}

					@Override
					public void onSuccess(Cines result) {
						// TODO Auto-generated method stub
						showCinesPlaces(result);
					}
				});
			}
		});
	}

	// A partir de aquí definimos los métodos para implementar las
	// funcionalidades
	private void showPeliculas(Peliculas peliculas) {
		final HorizontalPanel dock = new HorizontalPanel();
		Image poster = new Image();
		HTML title = new HTML("Películas actuales: ");
		if (peliculas != null) {
			for (int index = 0; index < 9; index++) {
				final Pelicula p = peliculas.getResults().get(index);

				Map<String, String> map = new HashMap<String, String>();

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
					}
				});

				dock.add(h);

				map.put("Pelicula", poster.getTitle() + "");
				// CineDeBarrio1.go("pelicula", map);
			}
		} else
			new HTML(
					"<span> Hay algun que otro problema, lo resolveremos lo antes posible</span>");

		RootPanel.get("top_valoradas").add(title);
		RootPanel.get("top_valoradas").add(dock);
	}

	private void showSeries(Collection<LSeries> listSeries) {
		HTML title = new HTML("Series actuales: ");

		final FlexTable indexTable = new FlexTable();
		Image poster = new Image();
		int index = 1;
		if (listSeries != null) {
			for (LSeries serie : listSeries) {

//				poster.setUrl(serie.getShow().getImages().getPoster()
//						.getThumb());

				indexTable.setText(0, 0, "Prueba");
				indexTable.setHTML(0, index, serie.getShow().getTitle());
				index++;
			}
		}
		RootPanel.get("top_valoradas").add(title);
		RootPanel.get("top_valoradas").add(indexTable);
	}

	private void showMultimediaTMDB(String busqueda, Busqueda result) {
		final HorizontalPanel indexTable = new HorizontalPanel();
		HTML title = new HTML("Busqueda en TMBD: " + busqueda);
		if (result != null) {
			for (int index = 0; index < 9; index++) {
				Multimedia multi = result.getResults().get(index);
				// Media_type: tv, movie
				if (multi.getTitle() == null) {
					indexTable.add(new HTML("<a href=>"
							+ "<img src=http://image.tmdb.org/t/p/w154"
							+ multi.getPoster_path() + ">" + "</a>"));
				} else
					indexTable.add(new HTML("<a href=>"
							+ "<img src=http://image.tmdb.org/t/p/w154"
							+ multi.getPoster_path() + ">" + "</a>"
							+ multi.getTitle()));
			}
		} else
			indexTable.add(new HTML("Sin resultados."));
		RootPanel.get("mostrar_busqueda").add(title);
		RootPanel.get("mostrar_busqueda").add(indexTable);
	}

	// private void showMediaTViso(String busqueda, BusquedaTviso
	// result) {
	// Media media0 = result.get0();
	//
	// String output = "<fieldset>";
	// output += "<legend> Busqueda en Tviso </legend>";
	// if (result != null) {
	// if (media0 != null) {
	// output += "<span>"
	// + media0.getVodBestOffer().getType()
	// + "</span>";
	// }
	// }
	// output += "</fieldset>";
	//
	// HTML multimedia = new HTML(output);
	//
	// RootPanel.get("mostrar_busqueda").add(multimedia);
	// }

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

	private void showSerieTrakttv(String busqueda, Collection<ListSeries> result) {
		final FlexTable indexTable = new FlexTable();
		Image poster = new Image();
		int index = 1;
		if (result != null) {
			for (ListSeries serie : result) {

				poster.setUrl(serie.getShow().getImages().getPoster()
						.getThumb());

				indexTable.setText(0, 0, "Prueba");
				indexTable.setHTML(0, index, poster
						+ serie.getShow().getTitle());
				index++;
			}
		}
		RootPanel.get("mostrar_busqueda").add(indexTable);
	}

}
