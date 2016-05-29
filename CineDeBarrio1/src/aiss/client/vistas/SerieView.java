package aiss.client.vistas;

import java.util.Map;

import aiss.shared.dominio.TMDB.serie.Serie;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SerieView extends Composite {

	final VerticalPanel panel = new VerticalPanel();

	public SerieView(Map<String, Object> params) {

		initWidget(panel);
		Serie serie = (Serie) params.get("serie");

		FlexTable primeraFila = new FlexTable();

		HTML title = new HTML();
		title.setText("Serie: " + serie.getName());
		title.getElement().setAttribute("id", "titulo");

		panel.add(title);

		Image poster = new Image();

		poster.setUrl("http://image.tmdb.org/t/p/w500" + serie.getPoster_path());
		poster.getElement().setAttribute("id", "poster");

		primeraFila.setHTML(0, 0, "" + poster);
		primeraFila.setHTML(0, 1, serie.getOverview());

		panel.add(primeraFila);
	}
}
