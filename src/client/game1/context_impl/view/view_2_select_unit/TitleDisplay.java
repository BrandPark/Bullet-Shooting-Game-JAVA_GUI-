package client.game1.context_impl.view.view_2_select_unit;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.Size;
import client.game1.Display;


class TitleDisplay implements Display{
	private Image img = Toolkit.getDefaultToolkit().getImage("resource/img/select_title.png");
	private int x = Size.FRAME_W/4;
	private int y = Size.FRAME_H/40;
	private int w = Size.FRAME_W/2;
	private int h = Size.FRAME_H/4;
	
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		if(g2d.drawImage(img, x, y, w, h,imageObserver))
			return true;
		return false;
	}

}
