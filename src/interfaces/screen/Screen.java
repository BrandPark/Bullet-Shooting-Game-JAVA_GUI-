package interfaces.screen;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public interface Screen{
	public void paint(Graphics2D g2d);
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
}
