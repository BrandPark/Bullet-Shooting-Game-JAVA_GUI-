package client.game1.context_impl.view._ingame;

import client.game1.Model;
import client.game1.Unit;
import client.game1.View;

abstract public class InGameViewFactory {
	public static View getView(Model model, Unit unit) {
		return new InGameView(model, unit);
	}
	public static Unit getUser1() {
		return new Unit1();
	}
}
