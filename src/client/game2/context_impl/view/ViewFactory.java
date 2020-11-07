package client.game2.context_impl.view;

import client.game2.Model;
import client.game2.View;
import client.game2.context_impl.view._main.MainViewFactory;
import client.game2.context_impl.view._select_unit.SelectUnitViewFactory;

abstract public class ViewFactory {
	public static final View getMainView(Model model) {
		return MainViewFactory.getView(model);
	}
	public static final View getSelectUnitView(Model model) {
		return SelectUnitViewFactory.getView(model);
	}
}
