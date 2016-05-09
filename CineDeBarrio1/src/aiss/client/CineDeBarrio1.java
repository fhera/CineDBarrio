package aiss.client;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import aiss.shared.dominio.places.Cine;
import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.Pelicula;
import aiss.shared.dominio.tmdb.Peliculas;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.tviso.BusquedaTviso;
import aiss.shared.dominio.tviso.Media;
import aiss.shared.dominio.tviso.Media1;
import aiss.shared.dominio.tviso.Media2;
import aiss.shared.dominio.tviso.Media3;
import aiss.shared.dominio.tviso.Media4;

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

@JsonIgnoreProperties(ignoreUnknown = true)
public class CineDeBarrio1 implements EntryPoint {

	private Button searchButton = new Button("Buscar");
	private TextBox searchField = new TextBox();
	private Label etiquetaEstado = new Label();
	private HorizontalPanel searchPanel = new HorizontalPanel();

	// En indexTable vamos a a�adir el cuerpo del HTML, tales como estrenos,
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

		servicio.getPelisMejoresValoradas(new AsyncCallback<Peliculas>() {

			@Override
			public void onSuccess(Peliculas peliculas) {
				showPeliculas(peliculas);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			private void showPeliculas(Peliculas peliculas) {
				String output = "Hola";

				if (peliculas != null) {
					for (Pelicula p : peliculas.getResults())
						output += "<span>" + p.getTitle() + "</span></br>";
				} else
					output += "<span> Hay algun que otro problema, lo resolveremos lo antes posible</span>";
				output += "</p>";

				HTML pelis = new HTML(output);
				RootPanel.get("top_valoradas").add(pelis);

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
							indexTable.setText(0, 0, "Busqueda en TMBD: "
									+ busqueda);
							indexTable.setText(0, 2, "Sinopsis");

							indexTable.setHTML(index, 0,
									"<img src=http://image.tmdb.org/t/p/w154"
											+ multi.getPoster_path() + ">");
							indexTable.setHTML(index, 1, a.getHTML());
							indexTable.setHTML(index, 2, multi.getOverview());
							indexTable.setHTML(index, 3, multi.getMedia_type());
						}
					}
				} else
					indexTable.setHTML(0, 0, "Sin resultados.");
				RootPanel.get("mostrar_busqueda").add(indexTable);

			}

			private void showMediaTViso(String busqueda, BusquedaTviso result) {
				Media media = result.get0();
				Media1 media1 = result.get1();
				Media2 media2 = result.get2();
				Media3 media3 = result.get3();
				Media4 media4 = result.get4();

				String output = "<fieldset>";
				output += "<legend> Busqueda en Tviso </legend>";
				if (result != null) {
					if (media != null) {
						output += "<span>" + media.getName() + "</span>";
					}
					if (media1 != null) {
						output += "<span> <br>" + media1.getName() + "</span>";
					}
					if (media2 != null) {
						output += "<span> <br>" + media2.getName() + "</span>";
					}
					if (media3 != null) {
						output += "<span> <br>" + media3.getName() + "</span>";
					}
					if (media4 != null) {
						output += "<span> <br>" + media4.getName() + "</span>";
					}
				}
				output += "</fieldset>";

				HTML multimedia = new HTML(output);

				RootPanel.get("mostrar_busqueda").add(multimedia);
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

		});

	}
}
