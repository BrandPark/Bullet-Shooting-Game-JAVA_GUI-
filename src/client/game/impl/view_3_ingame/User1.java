package client.game.impl.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.game.Bullet;
import client.game.HitBox;
import client.game.User;
import client.game.common.Direction;
import client.game.common.ImageUrl;
import client.game.common.Location;
import client.game.common.Size;

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
	private final DamageThread damageThread;
	private BulletType bulletType;
	private List<Bullet> bullets;
	private HitBox hitBox;
	
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
		this.damageThread = new DamageThread();
		this.hitBox = new HitBoxImpl(x+10,y+10,w-10,h-10);
	}
	
	@Override
	public void off() {
		shootThread.off();
	}
	
	@Override
	public void damage() {
		damageThread.damage();
	}

	@Override
	public boolean isDead() {
		if(life<=0)
			return true;
		return false;
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
	public boolean isHit(HitBox hitBox) {
		if(this.hitBox.isCrash(hitBox)) 
			return true;
		return false;
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
		hitBox.setLocation(x+10, y+10, w-10,h-10);
	}
	
	private boolean isInFrame() {
		if(x <= 0 || x >= Size.FRAME_W - Size.USER_W ||
				y <= 0 || y >= Size.FRAME_H - Size.USER_H)
			return false;
		return true;
	}
	private class DamageThread extends Thread{
		private boolean on; 
		private boolean isDamaged;
		DamageThread(){
			this.isDamaged = false;
			this.on = true;
			this.start();
		}

		@Override
		public void run() {
			while(true) {
				try {
					if(isDamaged)
						checkDamaged();
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		private void checkDamaged() {
			try {
				image = Toolkit.getDefaultToolkit().getImage(ImageUrl.OP_USER1);
				Thread.sleep(300);
				image = Toolkit.getDefaultToolkit().getImage(ImageUrl.USER1);
				Thread.sleep(300);
				image = Toolkit.getDefaultToolkit().getImage(ImageUrl.OP_USER1);
				Thread.sleep(300);
				image = Toolkit.getDefaultToolkit().getImage(ImageUrl.USER1);
				Thread.sleep(200);
				image = Toolkit.getDefaultToolkit().getImage(ImageUrl.OP_USER1);
				Thread.sleep(150);
				image = Toolkit.getDefaultToolkit().getImage(ImageUrl.USER1);
				Thread.sleep(100);
				image = Toolkit.getDefaultToolkit().getImage(ImageUrl.OP_USER1);
				Thread.sleep(50);
				image = Toolkit.getDefaultToolkit().getImage(ImageUrl.USER1);
				
				this.isDamaged = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		public void damage() {
			if(!isDamaged) {
				life--;
				this.isDamaged = true;
			}
		}
		
		public void off() {
			this.on = false;
			System.out.println("User_DamageThread OFF()...");
		}
		
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
			int shootX = x + (w/2) - (bulletType.getBulletWidth()/2);
			if(shootable) {
				bullets.add(bulletType.getBullet(shootX, y));
			}
			try {
				Thread.sleep(100);
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
