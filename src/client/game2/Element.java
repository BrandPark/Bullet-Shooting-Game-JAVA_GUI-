package client.game2;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public interface Element {
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver);
}
