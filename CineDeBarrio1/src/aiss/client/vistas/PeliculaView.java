package aiss.client.vistas;

import java.util.Map;

import aiss.client.APIService;
import aiss.client.APIServiceAsync;
import aiss.shared.dominio.TMDB.trailer.ListaTrailer;
import aiss.shared.dominio.TMDB.trailer.Trailer;
import aiss.shared.dominio.tmdb.buscar.Multimedia;

import com.google.gwt.core.client.GWT;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PeliculaView extends Composite {

	private final APIServiceAsync servicio = GWT.create(APIService.class);
	final VerticalPanel panel;
	final HorizontalPanel primeraFila;

	public PeliculaView(Map<String, Object> params) {

		panel = new VerticalPanel();
		initWidget(panel);
		Multimedia p = (Multimedia) params.get("pelicula");

		// Vamos a coger la url del trailer en esta llamada
		servicio.getVideo(p.getId(), new AsyncCallback<ListaTrailer>() {

			@Override
			public void onSuccess(ListaTrailer result) {
				showVideo(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("No existe trailer");
			}
		});

		HTML title = new HTML();
		title.setText("Pelicula: " + p.getTitle());
		title.getElement().setAttribute("id", "titulo");
		panel.add(title);

		primeraFila = new HorizontalPanel();
		Image poster = new Image();

		poster.setUrl("http://image.tmdb.org/t/p/w500" + p.getPoster_path());
		poster.getElement().setAttribute("id", "poster");

		primeraFila.add(poster);

		panel.add(primeraFila);
	}

	// A partir de aquí estan los métodos
	protected void showVideo(ListaTrailer result) {
		String keyTrailer = "";
		HTML urlTrailer = new HTML();
		Trailer trailer = result.getResults().get(0);
		if (trailer.getKey() != null) {
			keyTrailer = trailer.getKey();
		}
		urlTrailer.setText("http://www.youtube.com/embed/" + keyTrailer);

		Frame frame = new Frame(urlTrailer.getText());
		frame.getElement().setAttribute("width", "80%");
		frame.getElement().setAttribute("height", "150%");

		primeraFila.add(frame);
	}

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
