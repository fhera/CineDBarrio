package aiss.client.TMDB;

import aiss.client.APIService;
import aiss.client.APIServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class PeliculaView extends Composite {

	private final APIServiceAsync servicio = GWT.create(APIService.class);
	private final HorizontalPanel menu;

	public PeliculaView() {
		// TODO Auto-generated constructor stub

		menu = new HorizontalPanel();
		initWidget(menu);
		HTML h = new HTML("Probando las vistas");

		RootPanel.get("mostrar_busqueda").add(h);

	}

}
