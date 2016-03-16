package aiss.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dev.util.collect.HashMap;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CineDeBarrio implements EntryPoint {

	HorizontalPanel contenidoSelector = new HorizontalPanel();
	CwConstants cw;

	public void initBody() {
		// Create a Dock Panel
		DockPanel dock = new DockPanel();
		dock.setStyleName("cw-DockPanel");
		dock.setSpacing(4);
		dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);

		// Add text all around
		dock.add(new HTML(cw.cwDockPanelNorth1()), DockPanel.NORTH);
		dock.add(new HTML(cw.cwDockPanelSouth1()), DockPanel.SOUTH);
		dock.add(new HTML(cw.cwDockPanelEast()), DockPanel.EAST);
		dock.add(new HTML(cw.cwDockPanelWest()), DockPanel.WEST);
		dock.add(new HTML(cw.cwDockPanelNorth2()), DockPanel.NORTH);
		dock.add(new HTML(cw.cwDockPanelSouth2()), DockPanel.SOUTH);

		// Add scrollable text in the center
		HTML contents = new HTML(cw.cwDockPanelCenter());
		ScrollPanel scroller = new ScrollPanel(contents);
		scroller.setSize("400px", "100px");
		dock.add(scroller, DockPanel.CENTER);

		// Return the content
		dock.ensureDebugId("cwDockPanel");
	}

	public void onModuleLoad() {
		initBody();
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
}
