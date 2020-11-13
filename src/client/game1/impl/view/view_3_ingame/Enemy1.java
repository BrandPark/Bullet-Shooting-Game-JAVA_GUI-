package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.common.ImageUrl;
import client.common.Size;
import client.game1.Bullet;
import client.game1.Enemy;
import client.game1.HitBox;

public class Enemy1 implements Enemy, Runnable{
	private int life;
	private int x;
	private int y;
	private final int w;
	private final int h;
	private Image image;
	private HitBox hitBox;
	private BulletType bulletType;
	private List<Bullet> bullets;
	private Thread thread;
	private ShootThread shootThread;
	
	public Enemy1(int x, int y) {
		this.life = 3;
		this.x = x;
		this.y = y;
		this.w = Size.USER_W;
		this.h = Size.USER_H;
		this.hitBox = new HitBoxImpl(x,y,w,h);
		this.image = Toolkit.getDefaultToolkit().getImage(ImageUrl.ENEMY1);
		bulletType = BulletType.EnemyBullet1;
		bullets = new ArrayList<>();
		
	}
	
	@Override
	public void run() {
		while(life>0) {
			y++;
			bullets.add(bulletType.getBullet(x, y));
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void off() {
		this.life = 0;
		System.out.println("enemy 쓰레드 off");
	}

	@Override
	public void startMove() {
		thread = new Thread(this);
		thread.start();
		shootThread = new ShootThread();
	}

	@Override
	public List<Bullet> getBullets() {
		return bullets;
	}

	@Override
	public boolean isDead() {
		if(life<=0)
			return true;
		return false;
	}

	@Override
	public boolean isHit(HitBox hitBox) {
		if(this.hitBox.isCrash(hitBox)) 
			return true;
		return false;
	}

	@Override
	public void damage(int power) {
		life -= power;
	}

	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(image, -1, -1, imageObserver);
		if(g2d.drawImage(image, x, y, w, h, imageObserver))
			return true;
		return false;
	}
	
	private class ShootThread extends Thread{
		
		ShootThread(){
			this.start();
		}
		
		@Override
		public void run() {
			while(life > 0){
				addBullet();
			}
		}
		
		private void addBullet() {
			int centerX = x + (w/2) - 2;
			bullets.add(bulletType.getBullet(centerX, y));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
