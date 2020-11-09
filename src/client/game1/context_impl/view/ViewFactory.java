package client.game1.context_impl.view;

import client.game1.Model;
import client.game1.Unit;
import client.game1.View;
import client.game1.context_impl.view.view_1_main.MainViewFactory;
import client.game1.context_impl.view.view_2_select_unit.SelectUnitViewFactory;
import client.game1.context_impl.view.view_3_ingame.InGameViewFactory;

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
