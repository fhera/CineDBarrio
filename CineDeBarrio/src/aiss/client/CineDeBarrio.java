package aiss.client;

import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CineDeBarrio implements EntryPoint {

	HorizontalPanel contenidoSelector = new HorizontalPanel();

	public void onModuleLoad() {
		init();
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

	public void init() {
		final VerticalPanel mainPanel = new VerticalPanel();
		
		
	}
}
