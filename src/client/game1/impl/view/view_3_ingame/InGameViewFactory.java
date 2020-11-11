package client.game1.impl.view.view_3_ingame;

import client.game1.Model;
import client.game1.User;
import client.game1.View;

abstract public class InGameViewFactory {
	public static View getView(Model model, User unit) {
		return new InGameView(model, unit);
	}
	public static User getUser1() {
		return new User1();
	}
}
