package client.game.view;

import java.util.ArrayList;
import java.util.List;

import client.game.view.viewImpl_1.GameStartBtn;
import client.game.view.viewImpl_1.OptionBtn;
import client.game.view.viewImpl_2.ElementFactory;

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