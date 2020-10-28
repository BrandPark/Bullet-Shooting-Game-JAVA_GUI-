package client.game.view.impl;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.List;

import client.game.ActionQueue;
import client.game.ViewQueue;
import client.game.view.Button;
import client.game.view.Display;
import client.game.view.KeyHandler;
import client.game.view.View;

class MainView implements View{
	private final ActionQueue actionQueue;
	private final ViewQueue viewQueue;
	private final List<Button> buttons = ButtonListFactory.forMain();
	private final List<Display> displays = DisplayListFactory.forMain();
	
	KeyHandler focusHandler = new FocusHandler(buttons);
	
	public MainView(ViewQueue viewQueue, ActionQueue actionQueue) {
		this.viewQueue = viewQueue;
		this.actionQueue = actionQueue;
	}
	@Override
	public void paint(Graphics2D g2d,ImageObserver imageObserver) {
		for (Display d : displays) {
			d.paint(g2d, imageObserver);
		}
		for (Button b : buttons) {
			b.paint(g2d, imageObserver);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
		}
		focusHandler.keyPressed(e);
	}
}
