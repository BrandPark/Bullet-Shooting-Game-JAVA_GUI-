package game2.context_impl.view._main;

import game2.View;

abstract public class MainViewFactory {
	public static final View getView() {
		return new MainView();
	}
}
