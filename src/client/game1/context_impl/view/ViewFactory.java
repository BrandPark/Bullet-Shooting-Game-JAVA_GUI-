package client.game1.context_impl.view;

import client.game1.Model;
import client.game1.Unit;
import client.game1.View;
import client.game1.context_impl.view._ingame.InGameViewFactory;
import client.game1.context_impl.view._main.MainViewFactory;
import client.game1.context_impl.view._select_unit.SelectUnitViewFactory;

abstract public class ViewFactory {
	public static final View getMainView(Model model) {
		return MainViewFactory.getView(model);
	}
	public static final View getSelectUnitView(Model model) {
		return SelectUnitViewFactory.getView(model);
	}
	public static final View getInGameView(Model model, Unit unit) {
		return InGameViewFactory.getView(model, unit);
	}
}
