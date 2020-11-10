package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.List;

import client.common.Direction;
import client.common.Location;
import client.common.Size;
import client.game1.Bullet;
import client.game1.Unit;

class Unit1 implements Unit{
	private int power;
	private int speed;
	private int life;
	private int x;
	private int y;
	private final int w;
	private final int h;
	private Image image;
	private int moveDirection = 0;
	
	
	public Unit1() {
		this.power = 3;
		this.speed = 2;
		this.life = 3;
		this.x = Location.USER_X;
		this.y = Location.USER_Y;
		this.w = Size.USER_W;
		this.h = Size.USER_H;
		this.image = Toolkit.getDefaultToolkit().getImage("resource/img/unit/first_user.png");
	}
	
	@Override
	public void shoot(List<Bullet> list) {
		int centerX = x + (w/2) - 2;
		list.add(new Bullet1(centerX,y));
	}

	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		move();
		Toolkit.getDefaultToolkit().prepareImage(image, w, h, imageObserver);
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
}
