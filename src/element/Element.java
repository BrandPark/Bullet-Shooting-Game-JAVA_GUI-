package element;

import java.awt.Graphics2D;

public interface Element {
	public void move();
	public void stop();
	public void paint(Graphics2D g2d);
	
}
