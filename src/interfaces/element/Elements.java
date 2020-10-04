package interfaces.element;

import java.awt.Graphics2D;
import java.util.List;

public interface Elements{
	public List<Button> getButtons();
	public void allPaint(Graphics2D g2d);
}
