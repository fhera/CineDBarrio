package aiss.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CineDeBarrio implements EntryPoint {

	HorizontalPanel contenidoSelector = new HorizontalPanel();
	public void initBody() {
		// Create a Dock Panel
		DockPanel dock = new DockPanel();
		dock.setStyleName("cw-DockPanel");
		dock.setSpacing(4);
		dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);

		// Add text all around
		dock.add(new HTML(cwDockPanelNorth1()), DockPanel.NORTH);
		dock.add(new HTML(cwDockPanelSouth1()), DockPanel.SOUTH);
		dock.add(new HTML(cwDockPanelEast()), DockPanel.EAST);
		dock.add(new HTML(cwDockPanelWest()), DockPanel.WEST);
		dock.add(new HTML(cwDockPanelNorth2()), DockPanel.NORTH);
		dock.add(new HTML(cwDockPanelSouth2()), DockPanel.SOUTH);

		// Add scrollable text in the center
		HTML contents = new HTML(cwDockPanelCenter());
		ScrollPanel scroller = new ScrollPanel(contents);
		scroller.setSize("400px", "100px");
		dock.add(scroller, DockPanel.CENTER);

		// Return the content
		dock.ensureDebugId("cwDockPanel");
	}

	public void onModuleLoad() { 	
		initBody();

	}
}
