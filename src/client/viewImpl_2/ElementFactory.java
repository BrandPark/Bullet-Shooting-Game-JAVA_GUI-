package client.viewImpl_2;

import client.Button;
import client.Display;

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
	public static final Display selectTitle() {
		return new SelectTitle();
	}
}
