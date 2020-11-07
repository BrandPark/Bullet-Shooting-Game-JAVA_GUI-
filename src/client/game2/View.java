package client.game2;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public interface View {
	public void paint(Graphics2D g2d,ImageObserver imageObserver);
	public void stopView();
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
}