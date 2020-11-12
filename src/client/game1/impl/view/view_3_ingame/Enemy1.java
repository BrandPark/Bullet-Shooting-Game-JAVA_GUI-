package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.Size;
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
	
	public Enemy1(int x, int y) {
		this.life = 3;
		this.x = x;
		this.y = y;
		this.w = Size.USER_W;
		this.h = Size.USER_H;
		this.hitBox = new HitBoxImpl(x,y,w,h);
		this.image = Toolkit.getDefaultToolkit().getImage("resource/img/unit/enemy1.png");
	}
	
	@Override
	public void run() {
		while(life>0) {
			
		}
		System.out.println("죽음");
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
	public void diminishLife(int power) {
		life -= power;
	}

	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(image, -1, -1, imageObserver);
		if(g2d.drawImage(image, x, y, w, h, imageObserver))
			return true;
		return false;
	}

}
