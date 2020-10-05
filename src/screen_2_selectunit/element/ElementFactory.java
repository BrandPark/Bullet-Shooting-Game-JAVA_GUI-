package screen_2_selectunit.element;

import interfaces.element.Button;

abstract public class ElementFactory {
	public static final Button firstUserButton() {
		return new UserBtn1();
	}
	public static final Button secondUserButton() {
		return new UserBtn2();
	}
	public static final Button thirdUserButton() {
		return new UserBtn3();
	}
}
