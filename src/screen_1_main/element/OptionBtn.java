package screen_1_main.element;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import common.static_data.Size;
import interfaces.element.button.Button;

public class OptionBtn implements Button{
	private int x = Size.FRAME_W/8 * 3;
	private int y = Size.FRAME_H/6 + 300;
	private int w = Size.FRAME_W/4;
	private int h = Size.FRAME_H/10;
	private Image img = null;
	
	@Override
	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.black);
		g2d.fillRect(x, y, w, h);
	}

	@Override
	public void focus() {
		System.out.println("OptionBtn Focus()!!");
	}

	@Override
	public void unFocus() {
		System.out.println("OptionBtn unFocus()...");
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
