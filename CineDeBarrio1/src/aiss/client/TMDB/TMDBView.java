package aiss.client.TMDB;

import aiss.client.APIService;
import aiss.client.APIServiceAsync;
import aiss.shared.dominio.places.Cine;
import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.Pelicula;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.trakttv.ListSeries;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
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

		servicio.getPelisMejoresValoradas(new AsyncCallback<Peliculas>() {

			@Override
			public void onSuccess(Peliculas peliculas) {
				showPeliculasMejorValoradas(peliculas);
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
					servicio.getSerie(busqueda,
							new AsyncCallback<ListSeries>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub

								}

								@Override
								public void onSuccess(ListSeries result) {
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

	private void showPeliculasMejorValoradas(Peliculas peliculas) {
		final FlexTable indexTable = new FlexTable();
		if (peliculas != null) {
			for (final Pelicula p : peliculas.getResults()) {
				int index = peliculas.getResults().indexOf(p) + 1;

				indexTable.setText(0, 0, "Películas mejor valoradas: ");
				indexTable.setHTML(1, index,
						 "<img src=http://image.tmdb.org/t/p/w154"
								+ p.getPoster_path() + ">" );
				p.getPoster_path();
			}
		} else
			new HTML(
					"<span> Hay algun que otro problema, lo resolveremos lo antes posible</span>");

		RootPanel.get("top_valoradas").add(indexTable);
	}

	private void showMultimediaTMDB(String busqueda, Busqueda result) {
		final FlexTable indexTable = new FlexTable();
		Anchor a = new Anchor();

		if (result != null) {
			for (final Multimedia multi : result.getResults()) {
				// Media_type: tv, movie
				if (multi.getTitle() != null) {

					int index = result.getResults().indexOf(multi) + 1;

					a.setHTML(multi.getTitle());
					indexTable.setText(0, 0, "Busqueda en TMBD: " + busqueda);
					indexTable.setText(0, 2, "Sinopsis");

					indexTable.setHTML(
							index,
							0,
							"<img src=http://image.tmdb.org/t/p/w154"
									+ multi.getPoster_path() + ">");
					indexTable.setHTML(index, 1, a.getHref());
					indexTable.setHTML(index, 2, multi.getOverview());
					indexTable.setHTML(index, 3, multi.getMedia_type());
				}
			}
		} else
			indexTable.setHTML(0, 0, "Sin resultados.");
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

	private void showSerieTrakttv(String busqueda, ListSeries result) {
		final FlexTable indexTable = new FlexTable();
		if (result != null) {
			// for (final Show serie : result.getShow()) {
			int index = 1;
			indexTable.setText(0, 0, "Prueba");
			indexTable.setText(0, index, result.getType());
			// }
		}
		RootPanel.get("mostrar_busqueda").add(indexTable);
	}

}
