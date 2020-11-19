package client.game.impl.view_1_main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.game.Display;
import client.game.common.ImageUrl;
import client.game.common.Size;

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
