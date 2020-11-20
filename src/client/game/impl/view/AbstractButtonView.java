package client.game.impl.view;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.game.Button;
import client.game.Display;
import client.game.KeyHandler;
import client.game.Model;
import client.game.View;

abstract public class AbstractButtonView implements View {
	private final List<Button> buttons = new ArrayList<>();
	private final List<Display> displays = new ArrayList<>();
	private final KeyHandler buttonHandler;
	private final Model model;
	
	public AbstractButtonView(Model model) {
		this.model = model;
		initButtons();
		initDisplays();
		buttonHandler = new ButtonHandler(buttons,model);
	}
	
	abstract protected void initButtons();
	
	abstract protected void initDisplays();
	
	final protected void addButton(Button button) {
		buttons.add(button);
	}
	final protected void addDisplay(Display display) {
		displays.add(display);
	}
	
	@Override
	final public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		for (Display d : displays) {
			if(!d.paint(g2d, imageObserver))
				return false;
		}
		for (Button b : buttons) {
			if(!b.paint(g2d, imageObserver))
				return false;
		}
		return true;
	}
	
	@Override
	final public void keyPressed(KeyEvent e) {
		buttonHandler.keyPressed(e);
	}
	@Override
	final public void keyReleased(KeyEvent e) {
		buttonHandler.keyReleased(e);
	}
}
