package screen_1_main.element;

import interfaces.element.Button;
import interfaces.element.Display;

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
