package screen_1_main.element;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import common.static_data.Size;
import interfaces.element.Display;

public class Title implements Display{
	private int x = Size.FRAME_W/4;
	private int y = Size.FRAME_H/6;
	private int w = Size.FRAME_W/2;
	private int h = Size.FRAME_H/3;
	private Image img = null;
	
	public Title() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/title.png");
	}
	
	@Override
	public void paint(Graphics2D g2d) {
		g2d.drawImage(img,x,y,w,h,null);
	}

	
}
