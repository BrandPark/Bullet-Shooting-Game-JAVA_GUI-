package client.game.impl.view_1_main;

import client.game.Model;
import client.game.View;

abstract public class MainViewFactory {
	public static final View getView(Model model) {
		return new MainView(model);
	}
}
