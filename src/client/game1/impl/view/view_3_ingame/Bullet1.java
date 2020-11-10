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
	
	public Bullet1(int x, int y) {
		this.x = x;
		this.y = y;
		this.w = 20;
		this.h = 35;
		this.image = Toolkit.getDefaultToolkit().getImage("resource/img/bullet/bullet1.png");
		
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			y--;
			bulletSpeed(300);
		}
	}
	
	@Override
	public void remove() {
		thread.interrupt();
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
	
	
	
	private void bulletSpeed(int speed) {
		try {
			thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
