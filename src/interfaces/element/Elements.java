package interfaces.element;

import java.awt.Graphics2D;
import java.util.List;

import interfaces.element.button.Button;

public interface Elements{
	public List<Button> getButtons();
	public void allElementsPaint(Graphics2D g2d);
}
