package client.game.impl.viewImpl_1;

import java.util.ArrayList;
import java.util.List;

import client.game.Button;
import client.game.impl.viewImpl_2.ElementFactory;

abstract public class ButtonListFactory {
	public static final List<Button> forMain() {
		List<Button> buttons = new ArrayList<>();
		buttons.add(new GameStartBtn());
		buttons.add(new OptionBtn());
		
		return buttons;
	}
	
	public static final List<Button> forSelectUnit(){
		List<Button> buttons = new ArrayList<>();
		
		buttons.add(ElementFactory.firstUserButton());
		buttons.add(ElementFactory.secondUserButton());
		buttons.add(ElementFactory.thirdUserButton());
		
		return buttons;
	}
}
