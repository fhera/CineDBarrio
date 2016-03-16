package aiss.client;

import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

public class CineDeBarrio implements EntryPoint {

	HorizontalPanel contenidoSelector = new HorizontalPanel();

	public void onModuleLoad() {
		initHtml();
		go("init", new HashMap<String, String>());

	}

	private void go(String token, HashMap<String, String> params) {
		Panel p = RootPanel.get();
		if (token == "list" || token == "init") {
			p.clear();
			p.add(new ViewList(params));
		} else if (token == "create") {
			p.add(new ViewCreate(params));
		}
	}

	public HTMLPanel initHtml() {
		String htmlString = "Hola mundo";
		final HTMLPanel dock = new HTMLPanel(htmlString);
		return dock;
	}
}
