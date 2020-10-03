package screen_1_main.screen;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import interfaces.screen.KeyHandler;
import interfaces.screen.Screen;
import screen_1_main.element.MainElements;
import screen_1_main.handler.FocusHandlerImpl;

public class MainScreen implements Screen{
	MainElements elements = new MainElements();
	KeyHandler focusHandler = new FocusHandlerImpl(elements.getButtons());
	
	@Override
	public void paint(Graphics2D g2d) {
		elements.allElementsPaint(g2d);
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
