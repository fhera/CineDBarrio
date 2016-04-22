package aiss.client;

import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.tmdb.buscar.Result;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
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

	private FlexTable indexTable = new FlexTable();

	private final APIServiceAsync servicio = GWT.create(APIService.class);

	public void onModuleLoad() {

		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		searchPanel.add(etiquetaEstado);

		searchField.getElement().setAttribute("type", "text");
		searchField.getElement().setAttribute("id", "busqueda");
		searchField.getElement().setAttribute("class", "caja");
		searchField.getElement().setAttribute("placeholder", "Buscar aquí...");

		searchButton.getElement().setAttribute("id", "busqueda");
		etiquetaEstado.getElement().setAttribute("id", "busqueda");
		// searchButton.getElement().setAttribute("class", "boton");

		// Focus the cursor on the name field when the app loads
		searchField.setFocus(true);
		searchField.selectAll();

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

			@Override
			public void onClick(ClickEvent event) {
				etiquetaEstado.setText("Buscando...");

				final String busqueda = searchField.getText();

				RootPanel.get("top_valoradas").clear();
				RootPanel.get("peliculas").clear();
				RootPanel.get("mostrar_busqueda").clear();

				servicio.getBuscarMultimediaTMDB(busqueda,
						new AsyncCallback<Multimedia>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Error en la búsqueda: "
										+ caught.getMessage());
							}

							@Override
							public void onSuccess(Multimedia result) {
								showAlbums(busqueda, result);
								searchField.setText("");
								etiquetaEstado.setText("");
							}
						});
			}

			private void showAlbums(String busqueda, Multimedia result) {
				String output = "<fieldset>";
				output += "<legend> Coincidencias con: " + busqueda
						+ " </legend>";
				if (result != null) {
					for (Result multi : result.getResults()) {
						if (multi.getTitle() != null)
							output += "<span>" + multi.getTitle()
									+ "</span><br/>";
					}
				} else
					output = "<span> No results </span>";

				output += "</fieldset>";

				HTML multimedia = new HTML(output);

				RootPanel.get("mostrar_busqueda").add(multimedia);

			}

		});

	}
}
