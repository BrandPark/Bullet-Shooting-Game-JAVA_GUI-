package screen_1_main.element;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import interfaces.element.Elements;
import interfaces.element.button.Button;
import interfaces.element.display.Display;

public class MainElements implements Elements{
	private List<Button> buttons = new ArrayList<>();
	private List<Display> displays = new ArrayList<>();
	
	public MainElements() {
		displays.add(new Title());
		buttons.add(new GameStartBtn());
		buttons.add(new OptionBtn());
	}
	
	@Override
	public List<Button> getButtons() {
		return buttons;
	}

	@Override
	public void allElementsPaint(Graphics2D g2d) {
		for(Display d : displays) {
			d.paint(g2d);
		}
		for(Button b : buttons) {
			b.paint(g2d);
		}
	}

	

}
