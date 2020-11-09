package client.game1;

import java.awt.event.KeyEvent;

public interface Unit extends Element{
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
}
