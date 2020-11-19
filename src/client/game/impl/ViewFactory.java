package client.game.impl;

import client.game.Model;
import client.game.User;
import client.game.View;
import client.game.impl.view_1_main.MainViewFactory;
import client.game.impl.view_2_select_unit.SelectUnitViewFactory;
import client.game.impl.view_3_ingame.InGameViewFactory;

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
	public static final User getUser1() {
		return InGameViewFactory.getUser1();
	}
}
