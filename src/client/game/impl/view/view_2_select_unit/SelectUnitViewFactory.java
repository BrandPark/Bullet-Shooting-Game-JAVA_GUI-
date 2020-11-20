package client.game.impl.view.view_2_select_unit;

import client.game.Model;
import client.game.View;

abstract public class SelectUnitViewFactory {
	public static final View getView(Model model) {
		return new SelectUnitView(model);
	}
}
