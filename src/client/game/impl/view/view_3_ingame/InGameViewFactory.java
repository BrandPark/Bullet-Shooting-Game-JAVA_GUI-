package client.game.impl.view.view_3_ingame;

import client.game.Model;
import client.game.User;
import client.game.View;

abstract public class InGameViewFactory {
	public static final View getView(Model model, User unit) {
		return new InGameView(model, unit);
	}
	public static final User getUser1() {
		return new User1();
	}
	public static final User getUser2() {
		return new User2();
	}
	public static final User getUser3() {
		return new User3();
	}
}
