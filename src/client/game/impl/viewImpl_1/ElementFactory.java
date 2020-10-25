package client.game.impl.viewImpl_1;

import client.game.Button;
import client.game.Display;

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
