package client.game2.context_impl.view._ingame;

import client.game2.Model;
import client.game2.Unit;
import client.game2.View;

abstract public class InGameViewFactory {
	public static View getView(Model model, Unit unit) {
		return new InGameView(model, unit);
	}
	public static Unit getUser1() {
		return new Unit1();
	}
}
