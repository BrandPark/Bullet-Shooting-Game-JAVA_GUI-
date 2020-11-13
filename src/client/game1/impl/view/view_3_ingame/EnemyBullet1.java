package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.ImageUrl;
import client.common.Size;
import client.game1.Bullet;
import client.game1.HitBox;

public class EnemyBullet1 implements Bullet, Runnable{
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
	
	public EnemyBullet1(int x, int y) {
		this.x = x;
		this.y = y;
		this.w = 5;
		this.h = 35;
		this.power = 1;
		this.speed = 2;	
		this.img = Toolkit.getDefaultToolkit().getImage(ImageUrl.ENEMY_BULLET1);
		this.isValid = true;
		this.hitBox = new HitBoxImpl(x,y,w,h);
		
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(isValid) {
			y+=2;
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
		if(y > Size.FRAME_H)
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