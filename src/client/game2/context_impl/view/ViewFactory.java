package client.game2.context_impl.view;

import client.game2.View;
import client.game2.context_impl.view._main.MainViewFactory;

abstract public class ViewFactory {
	public static final View getMainView() {
		return MainViewFactory.getView();
	}
}
