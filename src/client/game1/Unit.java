package client.game1;

import java.util.List;

public interface Unit extends Element{
//	public void keyPressed(KeyEvent e);
//	public void keyReleased(KeyEvent e);
	public void setDirection(int moveDirection);
	public void shoot(List<Bullet> list);
}
