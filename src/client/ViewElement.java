package client;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public interface ViewElement {
	public void paint(Graphics2D g2d, ImageObserver imageObserver);
}
