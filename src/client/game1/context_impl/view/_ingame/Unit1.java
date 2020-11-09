package client.game1.context_impl.view._ingame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import client.common.Size;
import client.game1.Unit;

public class Unit1 implements Unit{
	private int power;
	private int speed;
	private int life;
	private int x;
	private int y;
	private final int w;
	private final int h;
	private Image image;
	
	private int moveDir = 0;
	private static final int RIGHT = 1;
	private static final int LEFT = 2;
	private static final int UP = 8;
	private static final int DOWN = 4;
	private static final int RIGHTUP = RIGHT | UP;
	private static final int RIGHTDOWN = RIGHT | DOWN;
	private static final int LEFTUP = LEFT | UP;
	private static final int LEFTDOWN = LEFT | DOWN;
	
	public Unit1() {
		this.power = 3;
		this.speed = 10;
		this.life = 3;
		this.x = Size.FRAME_W/2;
		this.y = Size.FRAME_H - 100;
		this.w = 30;
		this.h = 40;
		this.image = Toolkit.getDefaultToolkit().getImage("resource/img/unit/first_user.png");
	}
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		unitMove();
		if(g2d.drawImage(image, x, y, w, h, imageObserver))
			return true;
		return false;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) 
			moveDir = moveDir | UP;
		if(key == KeyEvent.VK_DOWN)
			moveDir = moveDir | DOWN;
		if(key == KeyEvent.VK_LEFT)
			moveDir = moveDir | LEFT;
		if(key == KeyEvent.VK_RIGHT)
			moveDir = moveDir | RIGHT;
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) 
			moveDir = moveDir ^ UP;
		if(key == KeyEvent.VK_DOWN)
			moveDir = moveDir ^ DOWN;
		if(key == KeyEvent.VK_LEFT)
			moveDir = moveDir ^ LEFT;
		if(key == KeyEvent.VK_RIGHT)
			moveDir = moveDir ^ RIGHT;
	}
	private void unitMove() {
		if(moveDir == UP) 
			y -= speed;
		else if(moveDir == DOWN) 
			y += speed;
		else if(moveDir == LEFT) 
			x -= speed;
		else if(moveDir == RIGHT) {
			x += speed;
		}
		else if(moveDir == LEFTUP) {
			x -= speed;
			y -= speed;
		}
		else if(moveDir == LEFTDOWN) {
			x -= speed;
			y += speed;
		}
		else if(moveDir == RIGHTUP) {
			x += speed;
			y -= speed;
		}
		else if(moveDir == RIGHTDOWN) {
			x += speed;
			y += speed;
		}
	}
}
