package client.game1;

import java.awt.event.KeyEvent;
import java.util.List;

public interface Unit extends Element{
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
	public void shoot(List<Bullet> list);
}
