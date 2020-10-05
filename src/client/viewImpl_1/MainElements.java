package client.viewImpl_1;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.Button;
import client.Display;
import client.Elements;

public class MainElements implements Elements {
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
		for (Display d : displays) {
			d.paint(g2d, imageObserver);
		}
		for (Button b : buttons) {
			b.paint(g2d, imageObserver);
		}
	}

}
