package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.common.Direction;
import client.common.ImageUrl;
import client.common.Location;
import client.common.Size;
import client.game1.Bullet;
import client.game1.User;

class User1 implements User{
	private int speed;
	private int life;
	private int x;
	private int y;
	private final int w;
	private final int h;
	private Image image;
	private int moveDirection = 0;
	private final ShootThread shootThread;
	private BulletType bulletType;
	private List<Bullet> bullets;
	
	public User1() {
		this.speed = 1;
		this.life = 3;
		this.x = Location.USER_X;
		this.y = Location.USER_Y;
		this.w = Size.USER_W;
		this.h = Size.USER_H;
		this.image = Toolkit.getDefaultToolkit().getImage(ImageUrl.USER1);
		this.bulletType = BulletType.UserBullet1;
		this.bullets = new ArrayList<Bullet>();
		this.shootThread = new ShootThread();
	}
	
	@Override
	public void off() {
		shootThread.off();
	}

	@Override
	public void shoot() {
		shootThread.shoot();
	}
	
	@Override
	public void stopShoot() {
		shootThread.stopShoot();
	}

	@Override
	public List<Bullet> getBullets() {
		return bullets;
	}

	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		move();
		Toolkit.getDefaultToolkit().prepareImage(image, -1, -1, imageObserver);
		if(g2d.drawImage(image, x, y, w, h, imageObserver))
			return true;
		return false;
	}
	
	@Override
	public void setDirection(int moveDirection) {
		this.moveDirection = moveDirection;
	}
	
	private void move() {
		int tempX = x;
		int tempY = y;
		if(moveDirection == Direction.UP) 
			y-=speed;
		else if(moveDirection == Direction.DOWN) 
			y+=speed;
		else if(moveDirection == Direction.LEFT) 
			x-=speed;
		else if(moveDirection == Direction.RIGHT) 
			x+=speed;
		else if(moveDirection == Direction.LEFTUP) {
			x-=speed;
			y-=speed;
		}
		else if(moveDirection == Direction.LEFTDOWN) {
			x-=speed;
			y+=speed;
		}
		else if(moveDirection == Direction.RIGHTUP) {
			x+=speed;
			y-=speed;
		}
		else if(moveDirection == Direction.RIGHTDOWN) {
			x+=speed;
			y+=speed;
		}
		if(!isInFrame()) {
			x = tempX;
			y = tempY;
		}
			
	}
	
	private boolean isInFrame() {
		if(x <= 0 || x >= Size.FRAME_W - Size.USER_W ||
				y <= 0 || y >= Size.FRAME_H - Size.USER_H)
			return false;
		return true;
	}
	
	private class ShootThread extends Thread{
		private boolean shootable;
		private boolean on;
		
		ShootThread(){
			this.shootable = false;
			this.start();
			this.on = true;
		}
		
		@Override
		public void run() {
			while(on){
				addBullet();
			}
		}
		
		private void addBullet() {
			int centerX = x + (w/2) - 2;
			if(shootable) {
				bullets.add(bulletType.getBullet(centerX, y));
			}
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		private void shoot() {
			shootable = true;
		}
		private void stopShoot() {
			shootable = false;
		}
		public void off() {
			this.on = false;
			System.out.println("User_SHootThread OFF()...");
		}
	}
}
