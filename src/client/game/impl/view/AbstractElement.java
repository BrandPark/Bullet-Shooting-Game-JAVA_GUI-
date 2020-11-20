package client.game.impl.view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.game.Element;

abstract public class AbstractElement implements Element{
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected Image img;
	
	public AbstractElement() {
		this.x = 0;
		this.y = 0;
		this.w = 0;
		this.h = 0;
		this.img = null;
	}
	
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver);
		if(g2d.drawImage(img,x,y,w,h,imageObserver))
			return true;
		return false;
	}  
	
	protected final Image getImage(String url) {
		return Toolkit.getDefaultToolkit().getImage(url);
	}
	
}
