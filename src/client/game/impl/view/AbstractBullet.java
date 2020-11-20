package client.game.impl.view;

import java.awt.Image;

import client.game.Bullet;
import client.game.HitBox;
import client.game.common.Size;

abstract public class AbstractBullet extends AbstractElement implements Runnable, Bullet{
	private int power;
	private int speed;
	private HitBox hitBox;
	private Thread thread;
	private boolean isValid;
	
	public AbstractBullet(int x, int y) {
		setX(x);
		setY(y);
		setWidth(initWidth());
		setHeight(initHeight());
		setImage(initImg());
		this.isValid = true;
		this.hitBox = initHitBox();
		this.power = initPower();
		this.speed = initSpeed();
		
		thread = new Thread(this);
		thread.start();
	}
	
	abstract protected HitBox initHitBox();
	abstract protected void bulletMove();
	abstract protected Image initImg();
	abstract protected int initPower();
	abstract protected int initSpeed();
	abstract protected int initWidth();
	abstract protected int initHeight();
	
	protected final void hitBoxMove(int x, int y, int w, int h) {
		hitBox.setLocation(x,y,w,h);
	}
	
	@Override
	public void run() {
		while(isValid) {
			bulletMove();
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
	
	private void bulletSpeed(long speed) {
		long delay = 11 - speed;
		if(delay <= 0)
			delay = 1;
		if(delay >= 11)
			delay = 10;
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
