package interfaces.screen;

import interfaces.element.Elements;
import screen_1_main.handler.FocusHandler;

abstract public class KeyHandlerFactory {
	public static final KeyHandler getHandlerToMain(Elements elements) {
		return new FocusHandler(elements);
	}
}
