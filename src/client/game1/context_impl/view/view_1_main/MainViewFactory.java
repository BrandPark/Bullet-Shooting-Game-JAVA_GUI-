package client.game1.context_impl.view.view_1_main;

import client.game1.Model;
import client.game1.View;

abstract public class MainViewFactory {
	public static final View getView(Model model) {
		return new MainView(model);
	}
}
