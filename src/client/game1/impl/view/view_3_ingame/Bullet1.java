package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.game1.Bullet;

public class Bullet1 implements Bullet, Runnable{
	private int x;
	private int y;
	private int w;
	private int h;
	private Image image;
	private int power;
	private int speed;
	private Thread thread;
	private boolean life;
	
	public Bullet1(int x, int y) {
		this.x = x;
		this.y = y;
		this.w = 5;
		this.h = 35;
		this.speed = 10;
		this.image = Toolkit.getDefaultToolkit().getImage("resource/img/bullet/bullet1.png");
		this.life = true;
		
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(life) {
			y-=speed;
			bulletSpeed(10);
		}
	}
	
	@Override
	synchronized public void remove() {
		life = false;
	}
	
	@Override
	public boolean isDead() {
		if(life)
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
		Toolkit.getDefaultToolkit().prepareImage(image, w, h, imageObserver);
		if(g2d.drawImage(image, x, y, w, h, imageObserver))
			return true;
		return false;
	}
	
	
	
	private void bulletSpeed(long speed) {
		try {
			thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
