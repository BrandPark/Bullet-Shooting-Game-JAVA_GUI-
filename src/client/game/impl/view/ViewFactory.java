package client.game.impl.view;

import client.game.Model;
import client.game.User;
import client.game.View;
import client.game.impl.view.view_1_main.MainViewFactory;
import client.game.impl.view.view_2_select_unit.SelectUnitViewFactory;
import client.game.impl.view.view_3_ingame.InGameViewFactory;

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
	public static final User getUser2() {
		return InGameViewFactory.getUser2();
	}
	public static final User getUser3() {
		return InGameViewFactory.getUser3();
	}
}
