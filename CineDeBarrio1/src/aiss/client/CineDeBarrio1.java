package aiss.client;

import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.tviso.BusquedaTviso;
import aiss.shared.dominio.tviso.Media;
import aiss.shared.dominio.tviso.Media1;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class CineDeBarrio1 implements EntryPoint {

	private Button searchButton = new Button("Buscar");
	private TextBox searchField = new TextBox();
	private Label etiquetaEstado = new Label();
	private HorizontalPanel searchPanel = new HorizontalPanel();

	// En indexTable vamos a añadir el cuerpo del HTML, tales como estrenos,
	// peliculas y series.

	private final APIServiceAsync servicio = GWT.create(APIService.class);

	public void onModuleLoad() {

		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		searchPanel.add(etiquetaEstado);

		searchField.getElement().setAttribute("type", "text");
		searchField.getElement().setAttribute("id", "busqueda");
		searchField.getElement().setAttribute("placeholder", "Buscar aqui...");

		searchButton.getElement().setAttribute("id", "busqueda");
		etiquetaEstado.getElement().setAttribute("id", "busqueda");

		RootPanel.get("busqueda").add(searchPanel);
		// // Parte donde se muestra las pelis.
		// for (int i = 0; i < 10; i++) {
		// for (int j = 0; j < 10; j++) {
		// indexTable.setText(i, j, "Peli " + i + j);
		//
		// }
		// }
		// S RootPanel.get("peliculas").add(indexTable);

		// servicio.getPelisMejoresValoradas(new AsyncCallback<Pelicula>() {
		//
		// @Override
		// public void onSuccess(Pelicula pelicula) {
		// showPeliculas(pelicula);
		// }
		//
		// private void showPeliculas(Pelicula pelicula) {
		// String output = "Hola";

		// if (pelicula != null) {
		// for (Result p : pelicula.getResults())
		// output += "<span>" + p.getTitle() + "</span></br>";
		// } else
		// output +=
		// "<span> Hay algún que otro problema, lo resolveremos lo antes posible</span>";
		// output += "</p>";
		//
		// HTML pelis = new HTML(output);
		// RootPanel.get("top_valoradas").add(pelis);
		//
		// }
		//
		// @Override
		// public void onFailure(Throwable caught) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// });

		searchButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				etiquetaEstado.setText("Buscando...");

				final String busqueda = searchField.getText();

				RootPanel.get("top_valoradas").clear();
				RootPanel.get("peliculas").clear();
				RootPanel.get("mostrar_busqueda").clear();

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
				servicio.getMediaPorTitulo(busqueda,
						new AsyncCallback<BusquedaTviso>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								Window.alert("Error en la busqueda: "
										+ caught.getMessage());

							}

							@Override
							public void onSuccess(BusquedaTviso result) {
								// TODO Auto-generated method stub
								showMediaTViso(busqueda, result);
								searchField.setText("");
								etiquetaEstado.setText("");
							}
						});
				
			}

			private void showMultimediaTMDB(String busqueda, Busqueda result) {
				final FlexTable indexTable = new FlexTable();
				Anchor a = new Anchor();
				// String res = "Multimedia toString: ";
				// res += "<br>" + result.toString();

				if (result != null) {
					for (final Multimedia multi : result.getResults()) {
						// Media_type: tv, movie
						if (multi.getTitle() != null) {

							int index = result.getResults().indexOf(multi) + 1;

							a.setHTML(multi.getTitle());
							indexTable.setText(0, 0, "Búsqueda en TMBD: " + busqueda);
							indexTable.setText(0, 2, "Sinopsis");

							indexTable.setHTML(index, 0,
									"<img src='http://image.tmdb.org/t/p/w500'"
											+ multi.getPoster_path() + ">");
							indexTable.setHTML(index, 1, a.getHTML());
							indexTable.setHTML(index, 2, multi.getOverview());
							indexTable.setHTML(index, 3, multi.getMedia_type());

							// a.addClickHandler(new ClickHandler() {
							//
							// @Override
							// public void onClick(ClickEvent event) {
							// // TODO Auto-generated method stub
							// RootPanel.get("top_valoradas").clear();
							// RootPanel.get("peliculas").clear();
							// RootPanel.get("mostrar_busqueda").clear();
							//
							// servicio.getPelicula(multi.getId(),
							// new AsyncCallback<Result>() {
							//
							// @Override
							// public void onFailure(
							// Throwable caught) {
							//
							// }
							//
							// @Override
							// public void onSuccess(
							// Result result) {
							// String output = "<fieldset>";
							// if (result != null) {
							// output += "<span>"
							// + result.getTitle()
							// + "</span>";
							// }
							// output += "</fieldset>";
							//
							// HTML multimedia = new HTML(
							// output);
							//
							// RootPanel.get(
							// "mostrar_busqueda")
							// .add(multimedia);
							//
							// }
							// });
							//
							// }
							// });

						}
					}
				} else
					indexTable.setHTML(0, 0, "Sin resultados.");
				RootPanel.get("mostrar_busqueda").add(indexTable);

			}

			private void showMediaTViso(String busqueda, BusquedaTviso result) {
				Media media = result.get0();
				Media1 media1 = result.get1();

				String output = "<fieldset>";
				output +="<legend> Búsqueda en Tviso </legend>";
				if (result != null) {
					output += "<span>" + media.getName() + "</span>";
					output+= "<span>" + media1.getName() + "</span>";
				}
				output += "</fieldset>";

				HTML multimedia = new HTML(output);

				RootPanel.get("mostrar_busqueda").add(multimedia);

			}

		});

	}
}
