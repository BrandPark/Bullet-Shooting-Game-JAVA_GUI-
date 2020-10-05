package client;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.List;

public interface Elements{
	public List<Button> getButtons();
	public void allPaint(Graphics2D g2d, ImageObserver imageObserver);
}
