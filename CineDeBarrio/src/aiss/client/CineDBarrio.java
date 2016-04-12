package aiss.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class CineDBarrio implements EntryPoint {

	private Button searchButton = new Button("Search");
	private TextBox searchField = new TextBox();
	private HorizontalPanel searchPanel = new HorizontalPanel();

	public void onModuleLoad() {

		searchField.setText("Buscar aquí...");
		
		searchField.getElement().setAttribute("id", "busqueda");
		
		searchPanel.add(searchField);
		searchPanel.add(searchButton);

		RootPanel.get("busqueda").add(searchPanel);

	}
}
