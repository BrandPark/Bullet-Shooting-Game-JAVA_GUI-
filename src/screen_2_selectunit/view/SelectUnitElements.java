package screen_2_selectunit.view;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import interfaces.element.Button;
import interfaces.element.Display;
import interfaces.element.Elements;
import screen_2_selectunit.element.ElementFactory;

public class SelectUnitElements implements Elements {
	private List<Button> buttons = new ArrayList<>();
	private List<Display> displays = new ArrayList<>();

	public SelectUnitElements() {
		buttons.add(ElementFactory.firstUserButton());
		buttons.add(ElementFactory.secondUserButton());
		buttons.add(ElementFactory.thirdUserButton());
		displays.add(ElementFactory.selectTitle());
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
