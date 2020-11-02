package client.game2.context_impl.view._main;

import client.game2.View;

abstract public class MainViewFactory {
	public static final View getView() {
		return new MainView();
	}
}
