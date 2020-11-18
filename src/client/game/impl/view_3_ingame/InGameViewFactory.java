package client.game.impl.view_3_ingame;

import client.game.Model;
import client.game.User;
import client.game.View;

abstract public class InGameViewFactory {
	public static View getView(Model model, User unit) {
		return new InGameView(model, unit);
	}
	public static User getUser1() {
		return new User1();
	}
}
