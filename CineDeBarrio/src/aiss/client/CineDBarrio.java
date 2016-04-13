package aiss.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class CineDBarrio implements EntryPoint {

	private Button searchButton = new Button("Buscar");
	private TextBox searchField = new TextBox();
	private Label etiquetaEstado = new Label();
	private HorizontalPanel searchPanel = new HorizontalPanel();

	// Aquí vamos a añadir el cuerpo del HTML, tales como estrenos, peliculas y
	// series.

	private FlexTable indexTable = new FlexTable();

	public void onModuleLoad() {

		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		searchPanel.add(etiquetaEstado);

		searchField.getElement().setAttribute("type", "text");
		searchField.getElement().setAttribute("id", "busqueda");
		searchField.getElement().setAttribute("class", "caja");
		searchField.getElement().setAttribute("placeholder", "Buscar aquí...");

		searchButton.getElement().setAttribute("id", "busqueda");
		searchButton.getElement().setAttribute("class", "boton");

		// Focus the cursor on the name field when the app loads
		searchField.setFocus(true);
		searchField.selectAll();

		RootPanel.get("busqueda").add(searchPanel);

		// Parte donde se muestra las pelis.
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				indexTable.setText(i, j, "Peli " + i + j);

			}
		}
		indexTable.setText(0, 0, "Peli 1");

		RootPanel.get("peliculas").add(indexTable);

		searchButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				etiquetaEstado.setText("Buscando...");

				final String multimedia = searchField.getText();
				RootPanel.get("form").clear();
			}
		});

	}
}
