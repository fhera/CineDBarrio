package aiss.client.vistas;

import java.util.HashMap;
import java.util.Map;

import aiss.client.CineDeBarrio1;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class VistaBase extends Composite {

	private final VerticalPanel menu;
	private final Button searchButton;
	private final TextBox searchField;
	private final Label etiquetaEstado;
	private final ListBox seleccionaBusqueda;

	public VistaBase(Map<String, Object> params) {

		// Panel principal e inicialización de la vista.
		menu = new VerticalPanel();
		initWidget(menu);
		seleccionaBusqueda = new ListBox();
		seleccionaBusqueda.addItem("Peliculas");
		seleccionaBusqueda.addItem("Series");

		searchButton = new Button("Buscar");
		searchField = new TextBox();
		etiquetaEstado = new Label();

		searchField.getElement().setAttribute("type", "text");
		searchField.getElement().setAttribute("id", "busqueda");
		searchField.getElement().setAttribute("placeholder", "Buscar aqui...");

		searchButton.getElement().setAttribute("id", "busqueda");
		etiquetaEstado.getElement().setAttribute("id", "busqueda");

		searchField.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					etiquetaEstado.setText("Buscando...");

					if (seleccionaBusqueda.getSelectedItemText() == "Peliculas") {

						Map<String, Object> map = new HashMap<String, Object>();
						map.put("busquedaPeliculas", searchField.getText());

						CineDeBarrio1.go("busqueda", map);
					} else {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("busquedaSeries", searchField.getText());

						CineDeBarrio1.go("busqueda", map);
					}

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
		menu.add(seleccionaBusqueda);
	}
}
