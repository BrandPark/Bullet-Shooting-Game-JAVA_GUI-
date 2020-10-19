package client.game.view.viewImpl_2;

import client.game.view.Button;
import client.game.view.Display;

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
