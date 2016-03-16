package aiss.client;

import java.util.HashMap;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class ViewList extends Composite {

	public ViewList(HashMap<String, String> params) {
		String htmlString = "";

		// Inicializacion de la vista
		final HTMLPanel dock = new HTMLPanel(htmlString);
		initWidget(dock);

		// Creamos el dock con las distintas partes que lo van a componer

	}

}
