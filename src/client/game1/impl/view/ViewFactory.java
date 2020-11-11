package client.game1.impl.view;

import client.game1.Model;
import client.game1.User;
import client.game1.View;
import client.game1.impl.view.view_1_main.MainViewFactory;
import client.game1.impl.view.view_2_select_unit.SelectUnitViewFactory;
import client.game1.impl.view.view_3_ingame.InGameViewFactory;

abstract public class ViewFactory {
	public static final View getMainView(Model model) {
		return MainViewFactory.getView(model);
	}
	public static final View getSelectUnitView(Model model) {
		return SelectUnitViewFactory.getView(model);
	}
	public static final View getInGameView(Model model, User unit) {
		return InGameViewFactory.getView(model, unit);
	}
}
