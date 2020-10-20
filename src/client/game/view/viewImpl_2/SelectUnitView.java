package client.game.view.viewImpl_2;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.List;

import client.game.view.Button;
import client.game.view.Display;
import client.game.view.KeyHandler;
import client.game.view.KeyHandlerFactory;
import client.game.view.View;
import client.game.view.viewImpl_1.ButtonListFactory;
import client.game.view.viewImpl_1.DisplayListFactory;

class SelectUnitView implements View{
	List<Button> buttons = ButtonListFactory.forSelectUnit();
	List<Display> displays = DisplayListFactory.forSelectUnit();
	
	private KeyHandler focusHandler = KeyHandlerFactory.getHandlerToSelectUnit(buttons);
	
	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
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
