package client.game1.impl.view.view_1_main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.ImageUrl;
import client.common.Size;
import client.game1.Display;

class TitleDisplay implements Display{
	private int x = Size.FRAME_W/4;
	private int y = Size.FRAME_H/6;
	private int w = Size.FRAME_W/2;
	private int h = Size.FRAME_H/3;
	private Image img = null;
	
	public TitleDisplay() {
		img = Toolkit.getDefaultToolkit().getImage(ImageUrl.MAIN_TITLE);
	}
	
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver);
		if(g2d.drawImage(img, x, y, w, h,imageObserver))
			return true;
		return false;
	}

	
}
