package aiss.client.vistas;

import java.util.HashMap;
import java.util.Map;

import aiss.client.APIService;
import aiss.client.APIServiceAsync;
import aiss.client.CineDeBarrio1;
import aiss.shared.dominio.tmdb.buscar.Busqueda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class VistaBase extends Composite {

	private final APIServiceAsync servicio = GWT.create(APIService.class);
	private final VerticalPanel menu;
	private final Button searchButton;
	private final TextBox searchField;
	private final Label etiquetaEstado;
	private final Label lbusqueda = new Label("");

	public VistaBase(Map<String, Object> params) {

		// Panel principal e inicialización de la vista.
		menu = new VerticalPanel();
		initWidget(menu);

		searchButton = new Button("Buscar");
		searchField = new TextBox();
		etiquetaEstado = new Label();

		searchField.getElement().setAttribute("type", "text");
		searchField.getElement().setAttribute("id", "busqueda");
		searchField.getElement().setAttribute("placeholder", "Buscar aqui...");

		menu.setStyleName("top_valoradas");

		searchButton.getElement().setAttribute("id", "busqueda");
		etiquetaEstado.getElement().setAttribute("id", "busqueda");

		searchField.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					etiquetaEstado.setText("Buscando...");

					Map<String, Object> map = new HashMap<String, Object>();
					map.put("busqueda", searchField.getText());

					CineDeBarrio1.go("busqueda", map);

					searchField.setText("");
					etiquetaEstado.setText("");
				}
			}
		});

		searchButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				etiquetaEstado.setText("Buscando...");

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("busqueda", searchField.getText());

				CineDeBarrio1.go("busqueda", map);

				searchField.setText("");
				etiquetaEstado.setText("");

			}

		});

		menu.add(searchButton);
		menu.add(searchField);
		menu.add(etiquetaEstado);
	}
}
