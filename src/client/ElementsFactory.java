package client;

import client.viewImpl_1.MainElements;
import client.viewImpl_2.SelectUnitElements;

abstract public class ElementsFactory {
	public static final Elements forMain() {
		return new MainElements();
	}
	public static final Elements forSelectUnit() {
		return new SelectUnitElements();
	}
}
