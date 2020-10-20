package client.game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public interface View{
	public void paint(Graphics2D g2d,ImageObserver imageObserver);
	public void keyPressed(KeyEvent e);
}
