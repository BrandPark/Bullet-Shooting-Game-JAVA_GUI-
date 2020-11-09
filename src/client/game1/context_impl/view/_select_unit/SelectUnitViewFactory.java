package client.game1.context_impl.view._select_unit;

import client.game1.Model;
import client.game1.View;

abstract public class SelectUnitViewFactory {
	public static View getView(Model model) {
		return new SelectUnitView(model);
	}
}
