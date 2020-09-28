package screen_1_main.screen;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import interfaces.screen.KeyHandler;
import interfaces.screen.Screen;
import screen_1_main.element.MainElements;

public class MainScreen implements Screen{
	private MainElements elements = new MainElements();
	private KeyHandler focusHandler = new FocusHandlerImpl(elements);
	
	@Override
	public void paint(Graphics2D g2d) {
		elements.allElementsPaint(g2d);
	}

	@Override
	public void remove() {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		focusHandler.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		focusHandler.keyReleased(e);
	}

}
