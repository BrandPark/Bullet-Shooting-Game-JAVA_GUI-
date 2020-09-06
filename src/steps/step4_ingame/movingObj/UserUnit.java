package steps.step4_ingame.movingObj;

import java.awt.event.KeyEvent;

import common.static_data.Location;
import common.static_data.Size;

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
		setLocation(Location.USER_X, Location.USER_Y);
		setSize(Size.USER_W, Size.USER_H);
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
		int setX = getX() + xa;
		int setY = getY() + ya;
		
		if(isInFrame(setX,setY)) {
			setLocation(setX,setY);
		}
		
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
	
	private boolean isInFrame(int x, int y) {
		int endX = x + Size.USER_W;
		int endY = y + Size.USER_H;
		
		if(x<0 || y<0 || endX>Size.FRAME_W || endY>Size.FRAME_H)
			return false;
		
		return true;
	}
	
	

	
	
	
	
}
