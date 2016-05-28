package aiss.client.vistas;

import java.util.Map;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PeliculaView extends Composite {

	final VerticalPanel panel;

	public PeliculaView(Map<String, Object> params) {

		panel = new VerticalPanel();
		initWidget(panel);
		
	}

}
