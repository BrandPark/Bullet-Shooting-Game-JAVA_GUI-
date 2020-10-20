package client.game.view.viewImpl_2;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.game.common.Size;
import client.game.view.Display;

class SelectTitle implements Display{
	private Image img = Toolkit.getDefaultToolkit().getImage("resource/img/select_title.png");
	private int x = Size.FRAME_W/4;
	private int y = Size.FRAME_H/40;
	private int w = Size.FRAME_W/2;
	private int h = Size.FRAME_H/4;
	
	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		g2d.drawImage(img,x,y,w,h,imageObserver);
		
	}

}
