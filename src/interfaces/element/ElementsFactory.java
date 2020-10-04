package interfaces.element;

import screen_1_main.element.MainElements;

abstract public class ElementsFactory {
	public static final Elements forMain() {
		return new MainElements();
	}
}
