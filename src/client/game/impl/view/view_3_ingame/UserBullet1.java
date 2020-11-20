package client.game.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.game.Bullet;
import client.game.HitBox;
import client.game.common.ImageUrl;
import client.game.common.Size;

class UserBullet1 implements Bullet, Runnable{
	private int x;
	private int y;
	private int w;
	private int h;
	private int power;
	private int speed;
	private Image img;
	private Thread thread;
	private boolean isValid;
	private HitBoxImpl hitBox;
	
	public UserBullet1(int x, int y) {
		this.x = x;
		this.y = y;
		this.w = Size.USER_BULLET1_W;
		this.h = Size.USER_BULLET1_H;
		this.power = 1;
		this.speed = 9;	
		this.img = Toolkit.getDefaultToolkit().getImage(ImageUrl.USER_BULLET1);
		this.isValid = true;
		this.hitBox = new HitBoxImpl(x,y,w,h);
		
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(isValid) {
			y-=2;
			hitBox.setLocation(x,y,w,h);
			bulletSpeed(speed);
		}
	}
	
	@Override
	public HitBox getHitBox() {
		return hitBox;
	}
	
	@Override
	public int getPower() {
		return power;
	}

	@Override
	synchronized public void remove() {
		isValid = false;
	}
	
	@Override
	public boolean isDead() {
		if(isValid)
			return false;
		return true;
	}
	
	@Override
	public boolean isInFrame() {
		if(y+h <= 0)
			return false;
		return true;
	}
	

	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver);
		if(g2d.drawImage(img, x, y, w, h, imageObserver))
			return true;
		return false;
	}
	
	
	
	private void bulletSpeed(long speed) {
		long delay = 11 - speed;
		if(delay <= 0)
			delay = 1;
		if(delay >= 11)
			delay = 10;
		try {
			thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
