package client;

import client.viewImpl_1.FocusHandler;

abstract public class KeyHandlerFactory {
	public static final KeyHandler getHandlerToMain(Elements elements) {
		return new FocusHandler(elements);
	}
	public static final KeyHandler getHandlerToSelectUnit(Elements elements) {
		return new FocusHandler(elements);
	}
}
