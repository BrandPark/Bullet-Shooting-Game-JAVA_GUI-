package client.viewImpl_2;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import client.Elements;
import client.ElementsFactory;
import client.KeyHandler;
import client.KeyHandlerFactory;
import client.Screen;

public class SelectUnitScreen implements Screen{
	private Elements elements = ElementsFactory.forSelectUnit();
	private KeyHandler handler = KeyHandlerFactory.getHandlerToSelectUnit(elements);
	
	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		elements.allPaint(g2d, imageObserver);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		handler.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
