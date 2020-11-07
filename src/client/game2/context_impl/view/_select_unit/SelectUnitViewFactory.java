package client.game2.context_impl.view._select_unit;

import client.game2.Model;
import client.game2.View;

abstract public class SelectUnitViewFactory {
	public static View getView(Model model) {
		return new SelectUnitView(model);
	}
}
