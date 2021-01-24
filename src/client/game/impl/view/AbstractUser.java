package client.game.impl.view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.game.Bullet;
import client.game.BulletType;
import client.game.HitBox;
import client.game.User;
import client.game.common.Direction;
import client.game.common.ImageUrl;
import client.game.common.Location;
import client.game.common.Size;

abstract public class AbstractUser extends AbstractElement implements User{
	
	private int speed;
	private BulletType bulletType;
	private int life;
	private int moveDirection;
	private final ShootThread shootThread;
	private final DamageThread damageThread;
	private List<Bullet> bullets;
	private HitBox hitBox;
	
	public AbstractUser() {
		setX(Location.USER_X);
		setY(Location.USER_Y);
		setWidth(Size.USER_W);
		setHeight(Size.USER_H);
		
		this.life=3;
		this.moveDirection = 0;
		this.bullets = new ArrayList<Bullet>();
		this.shootThread = new ShootThread();
		this.damageThread = new DamageThread();
		this.hitBox = new HitBoxImpl(getX()+10, getY()+10, getWidth()-10, getHeight()-10);
		this.speed = initSpeed();
		this.bulletType = initBulletType();
		setImage(initImg());
	}
	
	abstract protected int initSpeed();
	abstract protected BulletType initBulletType();
	abstract protected Image initImg();
		
	@Override
	public void off() {
		shootThread.off();
		damageThread.off();
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
		return super.paint(g2d, imageObserver);
	}
	
	@Override
	public void setDirection(int moveDirection) {
		this.moveDirection = moveDirection;
	}
	
	private void move() {
		int tempX = getX();
		int tempY = getY();
		if(moveDirection == Direction.UP) 
			setY(getY()-speed);
		else if(moveDirection == Direction.DOWN) 
			setY(getY()+speed);
		else if(moveDirection == Direction.LEFT) 
			setX(getX()-speed);
		else if(moveDirection == Direction.RIGHT) 
			setX(getX()+speed);
		else if(moveDirection == Direction.LEFTUP) {
			setX(getX()-speed);
			setY(getY()-speed);
		}
		else if(moveDirection == Direction.LEFTDOWN) {
			setX(getX()-speed);
			setY(getY()+speed);
		}
		else if(moveDirection == Direction.RIGHTUP) {
			setX(getX()+speed);
			setY(getY()-speed);
		}
		else if(moveDirection == Direction.RIGHTDOWN) {
			setX(getX()+speed);
			setY(getY()+speed);
		}
		if(!isInFrame()) {
			setX(tempX);
			setY(tempY);
		}
		hitBox.setLocation(getX()+10, getY()+10, getWidth()-10,getHeight()-10);
	}
	
	private boolean isInFrame() {
		if(getX() <= 0 || getX() >= Size.FRAME_W - Size.USER_W ||
				getY() <= 0 || getY() >= Size.FRAME_H - Size.USER_H)
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
			while(on) {
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
			Image tempImg = getImage();
			try {
				setImage(getImage(ImageUrl.OP_USER1));
				Thread.sleep(300);
				setImage(tempImg);
				Thread.sleep(300);
				setImage(getImage(ImageUrl.OP_USER1));
				Thread.sleep(300);
				setImage(tempImg);
				Thread.sleep(200);
				setImage(getImage(ImageUrl.OP_USER1));
				Thread.sleep(150);
				setImage(tempImg);
				Thread.sleep(100);
				setImage(getImage(ImageUrl.OP_USER1));
				Thread.sleep(50);
				setImage(tempImg);
				
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
	
	protected class ShootThread extends Thread{
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
		
		protected void addBullet() {
			if(shootable) {
				int shootX = getX() + (getWidth()/2) - 10;
				bullets.add(bulletType.getBullet(shootX, getY()));
			}
			try {
				Thread.sleep(10);
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
