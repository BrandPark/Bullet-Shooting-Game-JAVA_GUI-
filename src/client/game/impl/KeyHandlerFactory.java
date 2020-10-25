package client.game.impl;

import java.util.List;

import client.game.Button;
import client.game.impl.viewImpl_1.FocusHandler;

abstract public class KeyHandlerFactory {
	public static final KeyHandler getHandlerToMain(List<Button> buttons) {
		return new FocusHandler(buttons);
	}
	public static final KeyHandler getHandlerToSelectUnit(List<Button> buttons) {
		return new FocusHandler(buttons);
	}
}
