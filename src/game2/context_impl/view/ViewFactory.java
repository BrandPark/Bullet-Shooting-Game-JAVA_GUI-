package game2.context_impl.view;

import game2.View;
import game2.context_impl.view._main.MainViewFactory;

abstract public class ViewFactory {
	public static final View getMainView() {
		return MainViewFactory.getView();
	}
}
