package interfaces.element;

import screen_1_main.view.MainElements;
import screen_2_selectunit.view.SelectUnitElements;

abstract public class ElementsFactory {
	public static final Elements forMain() {
		return new MainElements();
	}
	public static final Elements forSelectUnit() {
		return new SelectUnitElements();
	}
}
