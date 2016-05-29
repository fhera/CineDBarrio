package aiss.client.vistas;

import java.util.Map;

import aiss.client.APIService;
import aiss.client.APIServiceAsync;
import aiss.shared.dominio.TMDB.trailer.ListaTrailer;
import aiss.shared.dominio.TMDB.trailer.Trailer;
import aiss.shared.dominio.places.Cine;
import aiss.shared.dominio.places.Cines;
import aiss.shared.dominio.tmdb.buscar.Multimedia;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.Position;
import com.google.gwt.geolocation.client.Position.Coordinates;
import com.google.gwt.geolocation.client.PositionError;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.InfoWindow;
import com.google.maps.gwt.client.InfoWindowOptions;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;
import com.google.maps.gwt.client.Marker;
import com.google.maps.gwt.client.Marker.ClickHandler;
import com.google.maps.gwt.client.MarkerOptions;
import com.google.maps.gwt.client.MouseEvent;

public class PeliculaView extends Composite {

	private final APIServiceAsync servicio = GWT.create(APIService.class);
	final VerticalPanel panel;
	final HorizontalPanel primeraFila;
	static GoogleMap map;

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

		servicio.getCinesCercanos(new AsyncCallback<Cines>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error en la busqueda de cines: "
						+ caught.getMessage());
			}

			@Override
			public void onSuccess(Cines result) {
				showMapCines(result);
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

	private static void showMapCines(Cines result) {

		System.out
				.println("Cines cerca de su posicion para poder ver la pelicula.");
		MapOptions myOptions = MapOptions.create();
		LatLng center = LatLng.create(37.35819, -5.98637);
		myOptions.setCenter(center);
		;
		myOptions.setZoom(15.0);
		myOptions.setMapTypeId(MapTypeId.ROADMAP);

		map = GoogleMap.create(Document.get().getElementById("map_canvas"),
				myOptions);
		showUserPosition();
		aniadeMarcadores(result, map);
	}

	private static void aniadeMarcadores(Cines result, final GoogleMap map) {

		for (Cine c : result.getResults()) {
			MarkerOptions markerOpts = MarkerOptions.create();
			markerOpts.setMap(map);
			markerOpts.setPosition(LatLng.create(c.getGeometry().getLocation()
					.getLat(), c.getGeometry().getLocation().getLng()));
			markerOpts.setTitle(c.getName());
			final Marker marker = Marker.create(markerOpts);

			InfoWindowOptions infowindowOptions = InfoWindowOptions.create();
			if (c.getRating() != null) {
				infowindowOptions
						.setContent("<b><center>" + c.getName()
								+ ".<center></b><br/>" + "Valoracion: "
								+ c.getRating());
				final InfoWindow infoWindow = InfoWindow
						.create(infowindowOptions);

				marker.addClickListener(new ClickHandler() {
					public void handle(MouseEvent event) {
						infoWindow.open(map, marker);
					}
				});
			} else {
				infowindowOptions.setContent("<b><center>" + c.getName()
						+ ".<center></b>");
				final InfoWindow infoWindow = InfoWindow
						.create(infowindowOptions);

				marker.addClickListener(new ClickHandler() {
					public void handle(MouseEvent event) {
						infoWindow.open(map, marker);
					}
				});
			}
		}
	}

	private static void showUserPosition() {
		/** TODO: Mostrar posicion del usuario */

		if (Geolocation.isSupported()) {
			Geolocation.getIfSupported().getCurrentPosition(
					new Callback<Position, PositionError>() {

						@Override
						public void onFailure(PositionError reason) {
							Window.alert("Ocurrio algo embarazoso: "
									+ reason.getMessage());
						}

						@Override
						public void onSuccess(Position result) {
							Coordinates coord = result.getCoordinates();
							LatLng mylocation = LatLng.create(
									coord.getLatitude(), coord.getLongitude());

							map.setCenter(mylocation);
							MarkerOptions markerOpt = MarkerOptions.create();

							markerOpt.setPosition(mylocation);
							markerOpt.setMap(map);
							markerOpt.setTitle("Mi posicion");
							markerOpt.setCursor("Tu Posicion");
							final Marker marker = Marker.create(markerOpt);

							InfoWindowOptions infoPositionOptions = InfoWindowOptions
									.create();
							infoPositionOptions
									.setContent("<b>Tu posicion.</b>");
							final InfoWindow infoWindow = InfoWindow
									.create(infoPositionOptions);

							marker.addClickListener(new ClickHandler() {
								public void handle(MouseEvent event) {
									infoWindow.open(map, marker);
								}
							});

						}
					});
		} else {

			Window.alert("No tienes geolocalizacion.");
		}
	}

}
