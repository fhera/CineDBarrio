package aiss.client.vistas;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import aiss.client.APIService;
import aiss.client.APIServiceAsync;
import aiss.client.CineDeBarrio1;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;
import aiss.shared.dominio.TMDB.serie.*;
import aiss.shared.dominio.trakttv.serie.ShowTrakt;
import aiss.shared.dominio.trakttv.serie.Shows;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BusquedaView extends Composite {

	private final APIServiceAsync servicio = GWT.create(APIService.class);
	private final VerticalPanel menu;
	private final FlexTable busquedaPanel;

	// final Label labelBusqueda = new Label();

	public BusquedaView(Map<String, Object> params) {

		menu = new VerticalPanel();
		initWidget(menu);

		busquedaPanel = new FlexTable();

		final String busquedaPeliculas = (String) params
				.get("busquedaPeliculas");
		final String busquedaSeries = (String) params.get("busquedaSeries");
		// final String busquedaSeries = busquedaSerie.replace(" ", "%20");

		if (busquedaPeliculas != null) {

			servicio.getBuscarMultimediaTMDB(busquedaPeliculas,
					new AsyncCallback<Busqueda>() {

						@Override
						public void onSuccess(Busqueda result) {
							showMultimediaTMDB(busquedaPeliculas, result);
						}

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Fallo al buscar peliculas: "
									+ caught.getMessage());
						}
					});
		} else if (busquedaSeries != null) {

			servicio.getBuscaSerie(busquedaSeries,
					new AsyncCallback<List<Serie>>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Fallo al buscar series: "
									+ caught.getMessage());
						}

						@Override
						public void onSuccess(List<Serie> result) {
							showSeries(busquedaSeries, result);
						}
					});
			// servicio.getSerieTraducida(busquedaSeries,
			// new AsyncCallback<Traduccion>() {
			//
			// @Override
			// public void onFailure(Throwable caught) {
			// // TODO Auto-generated method stub
			//
			// }
			//
			// @Override
			// public void onSuccess(Traduccion result) {
			// // TODO Auto-generated method stub
			//
			// }
			// });

		}
	}

	protected void showSeries(String busquedaSeries, List<Serie> result) {
		HTML title = new HTML("Busqueda : " + busquedaSeries);
		title.getElement().setAttribute("id", "titulo");

		Integer index = 0;
		final List<Serie> ls = new LinkedList<>();

		if (result != null) {
			for (final Serie serie : result) {

				ls.add(serie);

				Image poster = new Image();
				poster.setUrl("http://image.tmdb.org/t/p/w500"
						+ serie.getPoster_path());
				poster.setTitle(serie.getName());

				busquedaPanel.setHTML(index, 0, poster + "");
				busquedaPanel.setHTML(index, 1, serie.getName());
				busquedaPanel.setHTML(index, 2, serie.getOverview());
				index++;
			}
		} else
			busquedaPanel.setHTML(0, 0, "No se ha encontrado nada");

		busquedaPanel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				int fila = busquedaPanel.getCellForEvent(event).getRowIndex();

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("serie", ls.get(fila));
				CineDeBarrio1.go("serie", map);
			}

		});

		menu.add(title);
		menu.add(busquedaPanel);
	}

	private void showMultimediaTMDB(String busqueda, Busqueda result) {

		HTML title = new HTML("Busqueda : " + busqueda);
		title.getElement().setAttribute("id", "titulo");

		Integer index = 0;
		final List<Multimedia> ls = new LinkedList<Multimedia>();

		if (result != null) {
			for (final Multimedia multi : result.getResults()) {
				if (multi.getTitle() != null) {
					final Image poster = new Image();

					poster.setUrl("http://image.tmdb.org/t/p/w500"
							+ multi.getPoster_path());
					poster.setTitle(multi.getId().toString());

					ls.add(multi);

					busquedaPanel.setHTML(index, 0, poster + "");
					busquedaPanel.setHTML(index, 1, multi.getTitle());
					busquedaPanel.setHTML(index, 2, multi.getOverview());

					index++;
				}
			}
		} else {
			busquedaPanel.setHTML(2, 0, "Sin resultados.");
		}
		menu.add(title);
		menu.add(busquedaPanel);

		busquedaPanel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				int fila = busquedaPanel.getCellForEvent(event).getRowIndex();

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("pelicula", ls.get(fila));
				CineDeBarrio1.go("pelicula", map);
			}

		});
	}

}
