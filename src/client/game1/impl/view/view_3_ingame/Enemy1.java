package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.Size;
import client.game1.Enemy;
import client.game1.HitBox;

public class Enemy1 implements Enemy{
	private int life;
	private int x;
	private int y;
	private final int w;
	private final int h;
	private Image image;
	private HitBox hitBox;
	
	public Enemy1() {
		this.life = 3;
		this.x = 400;
		this.y = 100;
		this.w = Size.USER_W;
		this.h = Size.USER_H;
		this.hitBox = new HitBoxImpl(x+10,y+10,w-20,h-10);
		this.image = Toolkit.getDefaultToolkit().getImage("resource/img/unit/enemy1.png");
	}
	
	@Override
	public boolean isHit(HitBox hitBox) {
		if(this.hitBox.isCrash(hitBox)) {
			life--;
			System.out.println("life : " + life);
			return true;
		}
		return false;
	}

	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(image, w, h, imageObserver);
		if(g2d.drawImage(image, x, y, w, h, imageObserver))
			return true;
		return false;
	}

}
