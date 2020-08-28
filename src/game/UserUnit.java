package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class UserUnit extends Unit{
	
	private int moveDir = 0;
	
	private static final int RIGHT = 1;
	private static final int LEFT = 2;
	private static final int UP = 8;
	private static final int DOWN = 4;
	private static final int RIGHTUP = RIGHT | UP;
	private static final int RIGHTDOWN = RIGHT | DOWN;
	private static final int LEFTUP = LEFT | UP;
	private static final int LEFTDOWN = LEFT | DOWN;
	
	public UserUnit(String imageUrl) {
		super(imageUrl);
		setLife(3);
		setSpeed(5);
	}

	public void move() {
		int xa = 0;
		int ya = 0;
		
		if(moveDir == UP) 
			ya = getSpeed()*-1;
		else if(moveDir == DOWN) 
			ya = getSpeed();
		else if(moveDir == LEFT) 
			xa = getSpeed()*-1;
		else if(moveDir == RIGHT) {
			xa = getSpeed();
		}
		else if(moveDir == LEFTUP) {
			xa = getSpeed()*-1;
			ya = getSpeed()*-1;
		}
		else if(moveDir == LEFTDOWN) {
			xa = getSpeed()*-1;
			ya = getSpeed();
		}
		else if(moveDir == RIGHTUP) {
			xa = getSpeed();
			ya = getSpeed()*-1;
		}
		else if(moveDir == RIGHTDOWN) {
			xa = getSpeed();
			ya = getSpeed();
		}
		setLocation(getX()+xa, getY()+ya);
	}
	
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

	
	

	
	
	
	
}
