package client.game.impl.view;

import java.awt.Image;
import java.util.List;

import client.game.Bullet;
import client.game.BulletType;
import client.game.Enemy;
import client.game.HitBox;
import client.game.common.Size;

abstract public class AbstractEnemy extends AbstractElement implements Enemy, Runnable{
	
	private int life;
	private HitBox hitBox;
	private BulletType bulletType;
	private List<Bullet> bullets;
	private Thread enemyThread;
	private Thread shootThread;
	private AutoShoot autoShoot;
	
	public AbstractEnemy(int x, int y, List<Bullet> bullets) {
		this.life = initLife();
		setX(x);
		setY(y);
		setWidth(Size.ENEMY1_W);
		setHeight(Size.ENEMY1_H);
		setImage(initImage());
		this.hitBox = new HitBoxImpl(x,y,getWidth(),getHeight());
		this.bulletType = initBulletType();
		this.bullets = bullets;
		this.autoShoot = new AutoShoot();
	}
	
	abstract protected BulletType initBulletType();
	abstract protected Image initImage();
	abstract protected int initLife();
	
	protected final void hitBoxMove(int x, int y, int w, int h) {
		hitBox.setLocation(x,y,w,h);
	}
	
	@Override
	public void run() {
		while(life>0) {
			setY(getY()+1);
			hitBoxMove(getX(), getY(), getWidth(), getHeight());
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
	public boolean isInFrame() {
		if(getY() < Size.FRAME_H)
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

	private class AutoShoot implements Runnable{
		@Override
		public void run() {
			while(life > 0){
				addBullet();
			}
		}
		
		private void addBullet() {
			int shootX = getX() + (getWidth()/2) - 10;
			int shootY = getY() + getHeight();
			bullets.add(bulletType.getBullet(shootX, shootY));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}