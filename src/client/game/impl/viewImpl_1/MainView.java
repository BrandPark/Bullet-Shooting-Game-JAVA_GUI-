package client.game.impl.viewImpl_1;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.List;

import client.game.Button;
import client.game.Display;
import client.game.KeyHandler;
import client.game.View;
import client.game.impl.KeyHandlerFactory;

class MainView implements View{
	List<Button> buttons = ButtonListFactory.forMain();
	List<Display> displays = DisplayListFactory.forMain();
	
	KeyHandler focusHandler = KeyHandlerFactory.getHandlerToMain(buttons);
	
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
		focusHandler.keyPressed(e);
	}



}
