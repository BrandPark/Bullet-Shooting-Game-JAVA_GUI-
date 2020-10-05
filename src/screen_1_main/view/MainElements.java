package screen_1_main.view;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import interfaces.element.Button;
import interfaces.element.Display;
import interfaces.element.Elements;
import screen_1_main.element.GameStartBtn;
import screen_1_main.element.OptionBtn;
import screen_1_main.element.Title;

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
	public void allPaint(Graphics2D g2d, ImageObserver imageObserver) {
		for(Display d : displays) {
			d.paint(g2d, imageObserver);
		}
		for(Button b : buttons) {
			b.paint(g2d, imageObserver);
		}
	}



	

}
