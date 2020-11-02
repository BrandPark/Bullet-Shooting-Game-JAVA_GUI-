package client.game2.context_impl.view._main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.Size;
import client.game2.Display;

class TitleDisplay implements Display{
	private int x = Size.FRAME_W/4;
	private int y = Size.FRAME_H/6;
	private int w = Size.FRAME_W/2;
	private int h = Size.FRAME_H/3;
	private Image img = null;
	
	public TitleDisplay() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/title.png");
	}
	
	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		g2d.drawImage(img,x,y,w,h,imageObserver);
	}

	
}
