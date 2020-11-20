package client.game.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.List;

import client.game.Bullet;
import client.game.Enemy;
import client.game.HitBox;
import client.game.common.ImageUrl;
import client.game.common.Size;

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
	private Thread enemyThread;
	private Thread shootThread;
	private AutoShoot autoShoot;
	
	public Enemy1(int x, int y, List<Bullet> bullets) {
		this.life = 3;
		this.x = x;
		this.y = y;
		this.w = Size.ENEMY1_W;
		this.h = Size.ENEMY1_H;
		this.hitBox = new HitBoxImpl(x,y,w,h);
		this.image = Toolkit.getDefaultToolkit().getImage(ImageUrl.ENEMY1);
		this.bulletType = BulletType.EnemyBullet1;
		this.bullets = bullets;
		this.autoShoot = new AutoShoot();
	}
	
	@Override
	public void run() {
		while(life>0) {
			y++;
			hitBox.setLocation(x, y, w, h);
			try {
				Thread.sleep(10);
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
	public boolean isInFrame() {
		if(y < Size.FRAME_H)
			return true; 
		return false;
	}

	@Override
	public void startMove() {
		enemyThread = new Thread(this);
		enemyThread.start();
		shootThread = new Thread(autoShoot);
		shootThread.start();
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
	
	private class AutoShoot implements Runnable{
		@Override
		public void run() {
			while(life > 0){
				addBullet();
			}
		}
		
		private void addBullet() {
			int shootX = x + (w/2) - (bulletType.getBulletWidth()/2);
			int shootY = y + h;
			bullets.add(bulletType.getBullet(shootX, shootY));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
