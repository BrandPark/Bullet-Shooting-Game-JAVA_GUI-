package client.viewImpl_1;

import client.Button;
import client.Display;

public abstract class ElementFactory {
	public static final Button gameStartButton() {
		return new GameStartBtn();
	}
	public static final Button optionButton() {
		return new OptionBtn();
	}
	public static final Display title() {
		return new Title();
	}
}
