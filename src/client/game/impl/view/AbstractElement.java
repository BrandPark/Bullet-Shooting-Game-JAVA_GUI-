package client.game.impl.view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.game.Element;

abstract public class AbstractElement implements Element{
	private int x;
	private int y;
	private int w;
	private int h;
	private Image img;
	
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
	protected final void setX(int x) {
		this.x = x;
	}
	protected final void setY(int y) {
		this.y = y;
	}
	protected final int getX() {
		return x;
	}
	protected final int getY() {
		return y;
	}
	protected final void setWidth(int w) {
		this.w = w;
	}
	protected final int getWidth() {
		return w;
	}
	protected final void setHeight(int h) {
		this.h = h;
	}
	protected final int getHeight() {
		return h;
	}
	protected final void setImage(Image img) {
		this.img = img;
	}
	protected final Image getImage() {
		return img;
	}
}
