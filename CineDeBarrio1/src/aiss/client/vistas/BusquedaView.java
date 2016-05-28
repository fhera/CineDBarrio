package aiss.client.vistas;

import java.util.Map;

import aiss.client.APIService;
import aiss.client.APIServiceAsync;
import aiss.shared.dominio.tmdb.buscar.Busqueda;
import aiss.shared.dominio.tmdb.buscar.Multimedia;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class BusquedaView extends Composite {

	private final APIServiceAsync servicio = GWT.create(APIService.class);
	private final HorizontalPanel menu;
	private final FlexTable pelisPanel;
	private final FlexTable seriesPanel;
	final Label labelBusqueda = new Label();

	public BusquedaView(Map<String, Object> params) {
		// TODO Auto-generated constructor stub

		menu = new HorizontalPanel();
		initWidget(menu);

		pelisPanel = new FlexTable();
		seriesPanel = new FlexTable();
		labelBusqueda.setText((String) params.get("busqueda"));

		pelisPanel.setText(0, 0, "Prueba: ");
		pelisPanel.setText(0, 1, labelBusqueda.getText());

		menu.add(pelisPanel);
		// menu.add(seriesPanel);

		// servicio.getBuscarMultimediaTMDB(busqueda,
		// new AsyncCallback<Busqueda>() {
		// @Override
		// public void onFailure(Throwable caught) {
		// Window.alert("Error en la busqueda de peliculas: "
		// + caught.getMessage());
		// }
		//
		// @Override
		// public void onSuccess(Busqueda result) {
		// showMultimediaTMDB(busqueda, result);
		// // Map<String, String> map = new HashMap<String,
		// // String>();
		// // map.put("busqueda", result + "");
		// //
		// // CineDeBarrio1.go("peliculas", map);
		//
		// }
		// });
		// } else
		// Window.alert("No se pasan bien los maps");

		// servicio.getCinesCercanos(new AsyncCallback<Cines>() {
		//
		// @Override
		// public void onFailure(Throwable caught) {
		// Window.alert("Error en la busqueda de cines: "
		// + caught.getMessage());
		// }
		//
		// @Override
		// public void onSuccess(Cines result) {
		// showCinesPlaces(result);
		// }
		// });
		// }
		// });

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

		menu.add(title);
		menu.add(pelisPanel);
	}

}
