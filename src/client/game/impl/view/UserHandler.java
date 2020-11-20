package client.game.impl.view;

import java.awt.event.KeyEvent;

import client.game.KeyHandler;
import client.game.User;
import client.game.common.Direction;

public class UserHandler implements KeyHandler{
	private User unit;
	private int moveDir = 0;
	
	public UserHandler(User user) {
		this.unit = user;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) 
			moveDir = moveDir | Direction.UP;
		if(key == KeyEvent.VK_DOWN)
			moveDir = moveDir | Direction.DOWN;
		if(key == KeyEvent.VK_LEFT)
			moveDir = moveDir | Direction.LEFT;
		if(key == KeyEvent.VK_RIGHT)
			moveDir = moveDir | Direction.RIGHT;
		if(key == KeyEvent.VK_Z) 
			unit.shoot();
			
		unit.setDirection(moveDir);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) 
			moveDir = moveDir ^ Direction.UP;
		if(key == KeyEvent.VK_DOWN)
			moveDir = moveDir ^ Direction.DOWN;
		if(key == KeyEvent.VK_LEFT)
			moveDir = moveDir ^ Direction.LEFT;
		if(key == KeyEvent.VK_RIGHT)
			moveDir = moveDir ^ Direction.RIGHT;
		if(key == KeyEvent.VK_Z) 
			unit.stopShoot();
		unit.setDirection(moveDir);
	}
}
