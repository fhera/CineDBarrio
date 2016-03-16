package aiss.client;

import java.util.HashMap;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;

public class ViewCreate extends Composite {

	public ViewCreate(HashMap<String, String> params) {
		DockPanel dock = new DockPanel();
		initWidget(dock);
	}

}
