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
	private ActionQueue actionQueue = null;
	private ViewQueue viewQueue = null;
	List<Button> buttons = ButtonListFactory.forMain();
	List<Display> displays = DisplayListFactory.forMain();
	
	KeyHandler focusHandler = new FocusHandler(buttons);
	
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
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			viewQueue.add(new NextViewAction());
		focusHandler.keyPressed(e);
	}
	@Override
	public void addQueue(ActionQueue actionQueue, ViewQueue viewQueue) {
		this.actionQueue = actionQueue;
		this.viewQueue = viewQueue;
	}


}
